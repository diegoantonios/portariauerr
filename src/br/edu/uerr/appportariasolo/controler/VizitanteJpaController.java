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
import br.edu.uerr.appportariasolo.modelo.Vizitante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class VizitanteJpaController implements Serializable {

    public VizitanteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vizitante vizitante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Instituicao idInstituicaoFk = vizitante.getIdInstituicaoFk();
            if (idInstituicaoFk != null) {
                idInstituicaoFk = em.getReference(idInstituicaoFk.getClass(), idInstituicaoFk.getIdInstituicao());
                vizitante.setIdInstituicaoFk(idInstituicaoFk);
            }
            em.persist(vizitante);
            if (idInstituicaoFk != null) {
                idInstituicaoFk.getVizitanteList().add(vizitante);
                idInstituicaoFk = em.merge(idInstituicaoFk);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vizitante vizitante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vizitante persistentVizitante = em.find(Vizitante.class, vizitante.getIdVizitante());
            Instituicao idInstituicaoFkOld = persistentVizitante.getIdInstituicaoFk();
            Instituicao idInstituicaoFkNew = vizitante.getIdInstituicaoFk();
            if (idInstituicaoFkNew != null) {
                idInstituicaoFkNew = em.getReference(idInstituicaoFkNew.getClass(), idInstituicaoFkNew.getIdInstituicao());
                vizitante.setIdInstituicaoFk(idInstituicaoFkNew);
            }
            vizitante = em.merge(vizitante);
            if (idInstituicaoFkOld != null && !idInstituicaoFkOld.equals(idInstituicaoFkNew)) {
                idInstituicaoFkOld.getVizitanteList().remove(vizitante);
                idInstituicaoFkOld = em.merge(idInstituicaoFkOld);
            }
            if (idInstituicaoFkNew != null && !idInstituicaoFkNew.equals(idInstituicaoFkOld)) {
                idInstituicaoFkNew.getVizitanteList().add(vizitante);
                idInstituicaoFkNew = em.merge(idInstituicaoFkNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vizitante.getIdVizitante();
                if (findVizitante(id) == null) {
                    throw new NonexistentEntityException("The vizitante with id " + id + " no longer exists.");
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
            Vizitante vizitante;
            try {
                vizitante = em.getReference(Vizitante.class, id);
                vizitante.getIdVizitante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vizitante with id " + id + " no longer exists.", enfe);
            }
            Instituicao idInstituicaoFk = vizitante.getIdInstituicaoFk();
            if (idInstituicaoFk != null) {
                idInstituicaoFk.getVizitanteList().remove(vizitante);
                idInstituicaoFk = em.merge(idInstituicaoFk);
            }
            em.remove(vizitante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vizitante> findVizitanteEntities() {
        return findVizitanteEntities(true, -1, -1);
    }

    public List<Vizitante> findVizitanteEntities(int maxResults, int firstResult) {
        return findVizitanteEntities(false, maxResults, firstResult);
    }

    private List<Vizitante> findVizitanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vizitante.class));
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

    public Vizitante findVizitante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vizitante.class, id);
        } finally {
            em.close();
        }
    }

    public int getVizitanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vizitante> rt = cq.from(Vizitante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
