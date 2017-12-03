/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import br.edu.uerr.appportariasolo.modelo.Funcionario;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.uerr.appportariasolo.modelo.Setor;
import br.edu.uerr.appportariasolo.modelo.TipoFuncionario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class FuncionarioJpaController implements Serializable {

    public FuncionarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setor idSetorFk = funcionario.getIdSetorFk();
            if (idSetorFk != null) {
                idSetorFk = em.getReference(idSetorFk.getClass(), idSetorFk.getIdSetor());
                funcionario.setIdSetorFk(idSetorFk);
            }
            TipoFuncionario idTipoFuncionarioFk = funcionario.getIdTipoFuncionarioFk();
            if (idTipoFuncionarioFk != null) {
                idTipoFuncionarioFk = em.getReference(idTipoFuncionarioFk.getClass(), idTipoFuncionarioFk.getIdTipoFuncionario());
                funcionario.setIdTipoFuncionarioFk(idTipoFuncionarioFk);
            }
            em.persist(funcionario);
            if (idSetorFk != null) {
                idSetorFk.getFuncionarioList().add(funcionario);
                idSetorFk = em.merge(idSetorFk);
            }
            if (idTipoFuncionarioFk != null) {
                idTipoFuncionarioFk.getFuncionarioList().add(funcionario);
                idTipoFuncionarioFk = em.merge(idTipoFuncionarioFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario persistentFuncionario = em.find(Funcionario.class, funcionario.getIdFuncionario());
            Setor idSetorFkOld = persistentFuncionario.getIdSetorFk();
            Setor idSetorFkNew = funcionario.getIdSetorFk();
            TipoFuncionario idTipoFuncionarioFkOld = persistentFuncionario.getIdTipoFuncionarioFk();
            TipoFuncionario idTipoFuncionarioFkNew = funcionario.getIdTipoFuncionarioFk();
            if (idSetorFkNew != null) {
                idSetorFkNew = em.getReference(idSetorFkNew.getClass(), idSetorFkNew.getIdSetor());
                funcionario.setIdSetorFk(idSetorFkNew);
            }
            if (idTipoFuncionarioFkNew != null) {
                idTipoFuncionarioFkNew = em.getReference(idTipoFuncionarioFkNew.getClass(), idTipoFuncionarioFkNew.getIdTipoFuncionario());
                funcionario.setIdTipoFuncionarioFk(idTipoFuncionarioFkNew);
            }
            funcionario = em.merge(funcionario);
            if (idSetorFkOld != null && !idSetorFkOld.equals(idSetorFkNew)) {
                idSetorFkOld.getFuncionarioList().remove(funcionario);
                idSetorFkOld = em.merge(idSetorFkOld);
            }
            if (idSetorFkNew != null && !idSetorFkNew.equals(idSetorFkOld)) {
                idSetorFkNew.getFuncionarioList().add(funcionario);
                idSetorFkNew = em.merge(idSetorFkNew);
            }
            if (idTipoFuncionarioFkOld != null && !idTipoFuncionarioFkOld.equals(idTipoFuncionarioFkNew)) {
                idTipoFuncionarioFkOld.getFuncionarioList().remove(funcionario);
                idTipoFuncionarioFkOld = em.merge(idTipoFuncionarioFkOld);
            }
            if (idTipoFuncionarioFkNew != null && !idTipoFuncionarioFkNew.equals(idTipoFuncionarioFkOld)) {
                idTipoFuncionarioFkNew.getFuncionarioList().add(funcionario);
                idTipoFuncionarioFkNew = em.merge(idTipoFuncionarioFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = funcionario.getIdFuncionario();
                if (findFuncionario(id) == null) {
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
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
            Funcionario funcionario;
            try {
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getIdFuncionario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            Setor idSetorFk = funcionario.getIdSetorFk();
            if (idSetorFk != null) {
                idSetorFk.getFuncionarioList().remove(funcionario);
                idSetorFk = em.merge(idSetorFk);
            }
            TipoFuncionario idTipoFuncionarioFk = funcionario.getIdTipoFuncionarioFk();
            if (idTipoFuncionarioFk != null) {
                idTipoFuncionarioFk.getFuncionarioList().remove(funcionario);
                idTipoFuncionarioFk = em.merge(idTipoFuncionarioFk);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities() {
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult) {
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
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

    public Funcionario findFuncionario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Funcionario.class, id);
        } finally {
            em.close();
        }
    }

    public int getFuncionarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
