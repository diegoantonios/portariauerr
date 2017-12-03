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
import br.edu.uerr.appportariasolo.modelo.Aluno;
import br.edu.uerr.appportariasolo.modelo.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) {
        if (curso.getAlunoList() == null) {
            curso.setAlunoList(new ArrayList<Aluno>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Aluno> attachedAlunoList = new ArrayList<Aluno>();
            for (Aluno alunoListAlunoToAttach : curso.getAlunoList()) {
                alunoListAlunoToAttach = em.getReference(alunoListAlunoToAttach.getClass(), alunoListAlunoToAttach.getIdAluno());
                attachedAlunoList.add(alunoListAlunoToAttach);
            }
            curso.setAlunoList(attachedAlunoList);
            em.persist(curso);
            for (Aluno alunoListAluno : curso.getAlunoList()) {
                Curso oldIdCursoFkOfAlunoListAluno = alunoListAluno.getIdCursoFk();
                alunoListAluno.setIdCursoFk(curso);
                alunoListAluno = em.merge(alunoListAluno);
                if (oldIdCursoFkOfAlunoListAluno != null) {
                    oldIdCursoFkOfAlunoListAluno.getAlunoList().remove(alunoListAluno);
                    oldIdCursoFkOfAlunoListAluno = em.merge(oldIdCursoFkOfAlunoListAluno);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getIdCurso());
            List<Aluno> alunoListOld = persistentCurso.getAlunoList();
            List<Aluno> alunoListNew = curso.getAlunoList();
            List<Aluno> attachedAlunoListNew = new ArrayList<Aluno>();
            for (Aluno alunoListNewAlunoToAttach : alunoListNew) {
                alunoListNewAlunoToAttach = em.getReference(alunoListNewAlunoToAttach.getClass(), alunoListNewAlunoToAttach.getIdAluno());
                attachedAlunoListNew.add(alunoListNewAlunoToAttach);
            }
            alunoListNew = attachedAlunoListNew;
            curso.setAlunoList(alunoListNew);
            curso = em.merge(curso);
            for (Aluno alunoListOldAluno : alunoListOld) {
                if (!alunoListNew.contains(alunoListOldAluno)) {
                    alunoListOldAluno.setIdCursoFk(null);
                    alunoListOldAluno = em.merge(alunoListOldAluno);
                }
            }
            for (Aluno alunoListNewAluno : alunoListNew) {
                if (!alunoListOld.contains(alunoListNewAluno)) {
                    Curso oldIdCursoFkOfAlunoListNewAluno = alunoListNewAluno.getIdCursoFk();
                    alunoListNewAluno.setIdCursoFk(curso);
                    alunoListNewAluno = em.merge(alunoListNewAluno);
                    if (oldIdCursoFkOfAlunoListNewAluno != null && !oldIdCursoFkOfAlunoListNewAluno.equals(curso)) {
                        oldIdCursoFkOfAlunoListNewAluno.getAlunoList().remove(alunoListNewAluno);
                        oldIdCursoFkOfAlunoListNewAluno = em.merge(oldIdCursoFkOfAlunoListNewAluno);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = curso.getIdCurso();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getIdCurso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<Aluno> alunoList = curso.getAlunoList();
            for (Aluno alunoListAluno : alunoList) {
                alunoListAluno.setIdCursoFk(null);
                alunoListAluno = em.merge(alunoListAluno);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Curso> listaCursos(String n) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT id_curso FROM curso where nome_curso='" + n + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

}
