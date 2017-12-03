/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import br.edu.uerr.appportariasolo.modelo.Aluno;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.uerr.appportariasolo.modelo.Curso;
import br.edu.uerr.appportariasolo.modelo.Setor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class AlunoJpaController implements Serializable {

    public AlunoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aluno aluno) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso idCursoFk = aluno.getIdCursoFk();
            if (idCursoFk != null) {
                idCursoFk = em.getReference(idCursoFk.getClass(), idCursoFk.getIdCurso());
                aluno.setIdCursoFk(idCursoFk);
            }
            Setor idSetorFk = aluno.getIdSetorFk();
            if (idSetorFk != null) {
                idSetorFk = em.getReference(idSetorFk.getClass(), idSetorFk.getIdSetor());
                aluno.setIdSetorFk(idSetorFk);
            }
            em.persist(aluno);
            if (idCursoFk != null) {
                idCursoFk.getAlunoList().add(aluno);
                idCursoFk = em.merge(idCursoFk);
            }
            if (idSetorFk != null) {
                idSetorFk.getAlunoList().add(aluno);
                idSetorFk = em.merge(idSetorFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aluno aluno) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aluno persistentAluno = em.find(Aluno.class, aluno.getIdAluno());
            Curso idCursoFkOld = persistentAluno.getIdCursoFk();
            Curso idCursoFkNew = aluno.getIdCursoFk();
            Setor idSetorFkOld = persistentAluno.getIdSetorFk();
            Setor idSetorFkNew = aluno.getIdSetorFk();
            if (idCursoFkNew != null) {
                idCursoFkNew = em.getReference(idCursoFkNew.getClass(), idCursoFkNew.getIdCurso());
                aluno.setIdCursoFk(idCursoFkNew);
            }
            if (idSetorFkNew != null) {
                idSetorFkNew = em.getReference(idSetorFkNew.getClass(), idSetorFkNew.getIdSetor());
                aluno.setIdSetorFk(idSetorFkNew);
            }
            aluno = em.merge(aluno);
            if (idCursoFkOld != null && !idCursoFkOld.equals(idCursoFkNew)) {
                idCursoFkOld.getAlunoList().remove(aluno);
                idCursoFkOld = em.merge(idCursoFkOld);
            }
            if (idCursoFkNew != null && !idCursoFkNew.equals(idCursoFkOld)) {
                idCursoFkNew.getAlunoList().add(aluno);
                idCursoFkNew = em.merge(idCursoFkNew);
            }
            if (idSetorFkOld != null && !idSetorFkOld.equals(idSetorFkNew)) {
                idSetorFkOld.getAlunoList().remove(aluno);
                idSetorFkOld = em.merge(idSetorFkOld);
            }
            if (idSetorFkNew != null && !idSetorFkNew.equals(idSetorFkOld)) {
                idSetorFkNew.getAlunoList().add(aluno);
                idSetorFkNew = em.merge(idSetorFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = aluno.getIdAluno();
                if (findAluno(id) == null) {
                    throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.");
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
            Aluno aluno;
            try {
                aluno = em.getReference(Aluno.class, id);
                aluno.getIdAluno();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aluno with id " + id + " no longer exists.", enfe);
            }
            Curso idCursoFk = aluno.getIdCursoFk();
            if (idCursoFk != null) {
                idCursoFk.getAlunoList().remove(aluno);
                idCursoFk = em.merge(idCursoFk);
            }
            Setor idSetorFk = aluno.getIdSetorFk();
            if (idSetorFk != null) {
                idSetorFk.getAlunoList().remove(aluno);
                idSetorFk = em.merge(idSetorFk);
            }
            em.remove(aluno);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aluno> findAlunoEntities() {
        return findAlunoEntities(true, -1, -1);
    }

    public List<Aluno> findAlunoEntities(int maxResults, int firstResult) {
        return findAlunoEntities(false, maxResults, firstResult);
    }

    private List<Aluno> findAlunoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aluno.class));
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

    public Aluno findAluno(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aluno.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlunoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aluno> rt = cq.from(Aluno.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
