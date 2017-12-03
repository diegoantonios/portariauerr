/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.uerr.appportariasolo.modelo.Instituicao;
import br.edu.uerr.appportariasolo.modelo.Aluno;
import java.util.ArrayList;
import java.util.List;
import br.edu.uerr.appportariasolo.modelo.Funcionario;
import br.edu.uerr.appportariasolo.modelo.Setor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class SetorJpaController implements Serializable {

    public SetorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Setor setor) {
        if (setor.getAlunoList() == null) {
            setor.setAlunoList(new ArrayList<Aluno>());
        }
        if (setor.getFuncionarioList() == null) {
            setor.setFuncionarioList(new ArrayList<Funcionario>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Instituicao idInstituicaoFk = setor.getIdInstituicaoFk();
            if (idInstituicaoFk != null) {
                idInstituicaoFk = em.getReference(idInstituicaoFk.getClass(), idInstituicaoFk.getIdInstituicao());
                setor.setIdInstituicaoFk(idInstituicaoFk);
            }
            List<Aluno> attachedAlunoList = new ArrayList<Aluno>();
            for (Aluno alunoListAlunoToAttach : setor.getAlunoList()) {
                alunoListAlunoToAttach = em.getReference(alunoListAlunoToAttach.getClass(), alunoListAlunoToAttach.getIdAluno());
                attachedAlunoList.add(alunoListAlunoToAttach);
            }
            setor.setAlunoList(attachedAlunoList);
            List<Funcionario> attachedFuncionarioList = new ArrayList<Funcionario>();
            for (Funcionario funcionarioListFuncionarioToAttach : setor.getFuncionarioList()) {
                funcionarioListFuncionarioToAttach = em.getReference(funcionarioListFuncionarioToAttach.getClass(), funcionarioListFuncionarioToAttach.getIdFuncionario());
                attachedFuncionarioList.add(funcionarioListFuncionarioToAttach);
            }
            setor.setFuncionarioList(attachedFuncionarioList);
            em.persist(setor);
            if (idInstituicaoFk != null) {
                idInstituicaoFk.getSetorList().add(setor);
                idInstituicaoFk = em.merge(idInstituicaoFk);
            }
            for (Aluno alunoListAluno : setor.getAlunoList()) {
                Setor oldIdSetorFkOfAlunoListAluno = alunoListAluno.getIdSetorFk();
                alunoListAluno.setIdSetorFk(setor);
                alunoListAluno = em.merge(alunoListAluno);
                if (oldIdSetorFkOfAlunoListAluno != null) {
                    oldIdSetorFkOfAlunoListAluno.getAlunoList().remove(alunoListAluno);
                    oldIdSetorFkOfAlunoListAluno = em.merge(oldIdSetorFkOfAlunoListAluno);
                }
            }
            for (Funcionario funcionarioListFuncionario : setor.getFuncionarioList()) {
                Setor oldIdSetorFkOfFuncionarioListFuncionario = funcionarioListFuncionario.getIdSetorFk();
                funcionarioListFuncionario.setIdSetorFk(setor);
                funcionarioListFuncionario = em.merge(funcionarioListFuncionario);
                if (oldIdSetorFkOfFuncionarioListFuncionario != null) {
                    oldIdSetorFkOfFuncionarioListFuncionario.getFuncionarioList().remove(funcionarioListFuncionario);
                    oldIdSetorFkOfFuncionarioListFuncionario = em.merge(oldIdSetorFkOfFuncionarioListFuncionario);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Setor setor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setor persistentSetor = em.find(Setor.class, setor.getIdSetor());
            Instituicao idInstituicaoFkOld = persistentSetor.getIdInstituicaoFk();
            Instituicao idInstituicaoFkNew = setor.getIdInstituicaoFk();
            List<Aluno> alunoListOld = persistentSetor.getAlunoList();
            List<Aluno> alunoListNew = setor.getAlunoList();
            List<Funcionario> funcionarioListOld = persistentSetor.getFuncionarioList();
            List<Funcionario> funcionarioListNew = setor.getFuncionarioList();
            if (idInstituicaoFkNew != null) {
                idInstituicaoFkNew = em.getReference(idInstituicaoFkNew.getClass(), idInstituicaoFkNew.getIdInstituicao());
                setor.setIdInstituicaoFk(idInstituicaoFkNew);
            }
            List<Aluno> attachedAlunoListNew = new ArrayList<Aluno>();
            for (Aluno alunoListNewAlunoToAttach : alunoListNew) {
                alunoListNewAlunoToAttach = em.getReference(alunoListNewAlunoToAttach.getClass(), alunoListNewAlunoToAttach.getIdAluno());
                attachedAlunoListNew.add(alunoListNewAlunoToAttach);
            }
            alunoListNew = attachedAlunoListNew;
            setor.setAlunoList(alunoListNew);
            List<Funcionario> attachedFuncionarioListNew = new ArrayList<Funcionario>();
            for (Funcionario funcionarioListNewFuncionarioToAttach : funcionarioListNew) {
                funcionarioListNewFuncionarioToAttach = em.getReference(funcionarioListNewFuncionarioToAttach.getClass(), funcionarioListNewFuncionarioToAttach.getIdFuncionario());
                attachedFuncionarioListNew.add(funcionarioListNewFuncionarioToAttach);
            }
            funcionarioListNew = attachedFuncionarioListNew;
            setor.setFuncionarioList(funcionarioListNew);
            setor = em.merge(setor);
            if (idInstituicaoFkOld != null && !idInstituicaoFkOld.equals(idInstituicaoFkNew)) {
                idInstituicaoFkOld.getSetorList().remove(setor);
                idInstituicaoFkOld = em.merge(idInstituicaoFkOld);
            }
            if (idInstituicaoFkNew != null && !idInstituicaoFkNew.equals(idInstituicaoFkOld)) {
                idInstituicaoFkNew.getSetorList().add(setor);
                idInstituicaoFkNew = em.merge(idInstituicaoFkNew);
            }
            for (Aluno alunoListOldAluno : alunoListOld) {
                if (!alunoListNew.contains(alunoListOldAluno)) {
                    alunoListOldAluno.setIdSetorFk(null);
                    alunoListOldAluno = em.merge(alunoListOldAluno);
                }
            }
            for (Aluno alunoListNewAluno : alunoListNew) {
                if (!alunoListOld.contains(alunoListNewAluno)) {
                    Setor oldIdSetorFkOfAlunoListNewAluno = alunoListNewAluno.getIdSetorFk();
                    alunoListNewAluno.setIdSetorFk(setor);
                    alunoListNewAluno = em.merge(alunoListNewAluno);
                    if (oldIdSetorFkOfAlunoListNewAluno != null && !oldIdSetorFkOfAlunoListNewAluno.equals(setor)) {
                        oldIdSetorFkOfAlunoListNewAluno.getAlunoList().remove(alunoListNewAluno);
                        oldIdSetorFkOfAlunoListNewAluno = em.merge(oldIdSetorFkOfAlunoListNewAluno);
                    }
                }
            }
            for (Funcionario funcionarioListOldFuncionario : funcionarioListOld) {
                if (!funcionarioListNew.contains(funcionarioListOldFuncionario)) {
                    funcionarioListOldFuncionario.setIdSetorFk(null);
                    funcionarioListOldFuncionario = em.merge(funcionarioListOldFuncionario);
                }
            }
            for (Funcionario funcionarioListNewFuncionario : funcionarioListNew) {
                if (!funcionarioListOld.contains(funcionarioListNewFuncionario)) {
                    Setor oldIdSetorFkOfFuncionarioListNewFuncionario = funcionarioListNewFuncionario.getIdSetorFk();
                    funcionarioListNewFuncionario.setIdSetorFk(setor);
                    funcionarioListNewFuncionario = em.merge(funcionarioListNewFuncionario);
                    if (oldIdSetorFkOfFuncionarioListNewFuncionario != null && !oldIdSetorFkOfFuncionarioListNewFuncionario.equals(setor)) {
                        oldIdSetorFkOfFuncionarioListNewFuncionario.getFuncionarioList().remove(funcionarioListNewFuncionario);
                        oldIdSetorFkOfFuncionarioListNewFuncionario = em.merge(oldIdSetorFkOfFuncionarioListNewFuncionario);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = setor.getIdSetor();
                if (findSetor(id) == null) {
                    throw new NonexistentEntityException("The setor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setor setor;
            try {
                setor = em.getReference(Setor.class, id);
                setor.getIdSetor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The setor with id " + id + " no longer exists.", enfe);
            }
            Instituicao idInstituicaoFk = setor.getIdInstituicaoFk();
            if (idInstituicaoFk != null) {
                idInstituicaoFk.getSetorList().remove(setor);
                idInstituicaoFk = em.merge(idInstituicaoFk);
            }
            List<Aluno> alunoList = setor.getAlunoList();
            for (Aluno alunoListAluno : alunoList) {
                alunoListAluno.setIdSetorFk(null);
                alunoListAluno = em.merge(alunoListAluno);
            }
            List<Funcionario> funcionarioList = setor.getFuncionarioList();
            for (Funcionario funcionarioListFuncionario : funcionarioList) {
                funcionarioListFuncionario.setIdSetorFk(null);
                funcionarioListFuncionario = em.merge(funcionarioListFuncionario);
            }
            em.remove(setor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Setor> findSetorEntities() {
        return findSetorEntities(true, -1, -1);
    }

    public List<Setor> findSetorEntities(int maxResults, int firstResult) {
        return findSetorEntities(false, maxResults, firstResult);
    }

    private List<Setor> findSetorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Setor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Setor findSetor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Setor.class, id);
        } finally {
            em.close();
        }
    }

    public int getSetorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Setor> rt = cq.from(Setor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        public List<Setor> listaSetor(String n) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT id_setor FROM setor where nome_setor='"+ n +"'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }
    
}
