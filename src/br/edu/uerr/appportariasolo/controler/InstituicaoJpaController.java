/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import br.edu.uerr.appportariasolo.modelo.Instituicao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.edu.uerr.appportariasolo.modelo.Setor;
import java.util.ArrayList;
import java.util.List;
import br.edu.uerr.appportariasolo.modelo.Vizitante;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Diego_Note
 */
public class InstituicaoJpaController implements Serializable {

    public InstituicaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Instituicao instituicao) {
        if (instituicao.getSetorList() == null) {
            instituicao.setSetorList(new ArrayList<Setor>());
        }
        if (instituicao.getVizitanteList() == null) {
            instituicao.setVizitanteList(new ArrayList<Vizitante>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Setor> attachedSetorList = new ArrayList<Setor>();
            for (Setor setorListSetorToAttach : instituicao.getSetorList()) {
                setorListSetorToAttach = em.getReference(setorListSetorToAttach.getClass(), setorListSetorToAttach.getIdSetor());
                attachedSetorList.add(setorListSetorToAttach);
            }
            instituicao.setSetorList(attachedSetorList);
            List<Vizitante> attachedVizitanteList = new ArrayList<Vizitante>();
            for (Vizitante vizitanteListVizitanteToAttach : instituicao.getVizitanteList()) {
                vizitanteListVizitanteToAttach = em.getReference(vizitanteListVizitanteToAttach.getClass(), vizitanteListVizitanteToAttach.getIdVizitante());
                attachedVizitanteList.add(vizitanteListVizitanteToAttach);
            }
            instituicao.setVizitanteList(attachedVizitanteList);
            em.persist(instituicao);
            for (Setor setorListSetor : instituicao.getSetorList()) {
                Instituicao oldIdInstituicaoFkOfSetorListSetor = setorListSetor.getIdInstituicaoFk();
                setorListSetor.setIdInstituicaoFk(instituicao);
                setorListSetor = em.merge(setorListSetor);
                if (oldIdInstituicaoFkOfSetorListSetor != null) {
                    oldIdInstituicaoFkOfSetorListSetor.getSetorList().remove(setorListSetor);
                    oldIdInstituicaoFkOfSetorListSetor = em.merge(oldIdInstituicaoFkOfSetorListSetor);
                }
            }
            for (Vizitante vizitanteListVizitante : instituicao.getVizitanteList()) {
                Instituicao oldIdInstituicaoFkOfVizitanteListVizitante = vizitanteListVizitante.getIdInstituicaoFk();
                vizitanteListVizitante.setIdInstituicaoFk(instituicao);
                vizitanteListVizitante = em.merge(vizitanteListVizitante);
                if (oldIdInstituicaoFkOfVizitanteListVizitante != null) {
                    oldIdInstituicaoFkOfVizitanteListVizitante.getVizitanteList().remove(vizitanteListVizitante);
                    oldIdInstituicaoFkOfVizitanteListVizitante = em.merge(oldIdInstituicaoFkOfVizitanteListVizitante);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Instituicao instituicao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Instituicao persistentInstituicao = em.find(Instituicao.class, instituicao.getIdInstituicao());
            List<Setor> setorListOld = persistentInstituicao.getSetorList();
            List<Setor> setorListNew = instituicao.getSetorList();
            List<Vizitante> vizitanteListOld = persistentInstituicao.getVizitanteList();
            List<Vizitante> vizitanteListNew = instituicao.getVizitanteList();
            List<Setor> attachedSetorListNew = new ArrayList<Setor>();
            for (Setor setorListNewSetorToAttach : setorListNew) {
                setorListNewSetorToAttach = em.getReference(setorListNewSetorToAttach.getClass(), setorListNewSetorToAttach.getIdSetor());
                attachedSetorListNew.add(setorListNewSetorToAttach);
            }
            setorListNew = attachedSetorListNew;
            instituicao.setSetorList(setorListNew);
            List<Vizitante> attachedVizitanteListNew = new ArrayList<Vizitante>();
            for (Vizitante vizitanteListNewVizitanteToAttach : vizitanteListNew) {
                vizitanteListNewVizitanteToAttach = em.getReference(vizitanteListNewVizitanteToAttach.getClass(), vizitanteListNewVizitanteToAttach.getIdVizitante());
                attachedVizitanteListNew.add(vizitanteListNewVizitanteToAttach);
            }
            vizitanteListNew = attachedVizitanteListNew;
            instituicao.setVizitanteList(vizitanteListNew);
            instituicao = em.merge(instituicao);
            for (Setor setorListOldSetor : setorListOld) {
                if (!setorListNew.contains(setorListOldSetor)) {
                    setorListOldSetor.setIdInstituicaoFk(null);
                    setorListOldSetor = em.merge(setorListOldSetor);
                }
            }
            for (Setor setorListNewSetor : setorListNew) {
                if (!setorListOld.contains(setorListNewSetor)) {
                    Instituicao oldIdInstituicaoFkOfSetorListNewSetor = setorListNewSetor.getIdInstituicaoFk();
                    setorListNewSetor.setIdInstituicaoFk(instituicao);
                    setorListNewSetor = em.merge(setorListNewSetor);
                    if (oldIdInstituicaoFkOfSetorListNewSetor != null && !oldIdInstituicaoFkOfSetorListNewSetor.equals(instituicao)) {
                        oldIdInstituicaoFkOfSetorListNewSetor.getSetorList().remove(setorListNewSetor);
                        oldIdInstituicaoFkOfSetorListNewSetor = em.merge(oldIdInstituicaoFkOfSetorListNewSetor);
                    }
                }
            }
            for (Vizitante vizitanteListOldVizitante : vizitanteListOld) {
                if (!vizitanteListNew.contains(vizitanteListOldVizitante)) {
                    vizitanteListOldVizitante.setIdInstituicaoFk(null);
                    vizitanteListOldVizitante = em.merge(vizitanteListOldVizitante);
                }
            }
            for (Vizitante vizitanteListNewVizitante : vizitanteListNew) {
                if (!vizitanteListOld.contains(vizitanteListNewVizitante)) {
                    Instituicao oldIdInstituicaoFkOfVizitanteListNewVizitante = vizitanteListNewVizitante.getIdInstituicaoFk();
                    vizitanteListNewVizitante.setIdInstituicaoFk(instituicao);
                    vizitanteListNewVizitante = em.merge(vizitanteListNewVizitante);
                    if (oldIdInstituicaoFkOfVizitanteListNewVizitante != null && !oldIdInstituicaoFkOfVizitanteListNewVizitante.equals(instituicao)) {
                        oldIdInstituicaoFkOfVizitanteListNewVizitante.getVizitanteList().remove(vizitanteListNewVizitante);
                        oldIdInstituicaoFkOfVizitanteListNewVizitante = em.merge(oldIdInstituicaoFkOfVizitanteListNewVizitante);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = instituicao.getIdInstituicao();
                if (findInstituicao(id) == null) {
                    throw new NonexistentEntityException("The instituicao with id " + id + " no longer exists.");
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
            Instituicao instituicao;
            try {
                instituicao = em.getReference(Instituicao.class, id);
                instituicao.getIdInstituicao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The instituicao with id " + id + " no longer exists.", enfe);
            }
            List<Setor> setorList = instituicao.getSetorList();
            for (Setor setorListSetor : setorList) {
                setorListSetor.setIdInstituicaoFk(null);
                setorListSetor = em.merge(setorListSetor);
            }
            List<Vizitante> vizitanteList = instituicao.getVizitanteList();
            for (Vizitante vizitanteListVizitante : vizitanteList) {
                vizitanteListVizitante.setIdInstituicaoFk(null);
                vizitanteListVizitante = em.merge(vizitanteListVizitante);
            }
            em.remove(instituicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Instituicao> findInstituicaoEntities() {
        return findInstituicaoEntities(true, -1, -1);
    }

    public List<Instituicao> findInstituicaoEntities(int maxResults, int firstResult) {
        return findInstituicaoEntities(false, maxResults, firstResult);
    }

    private List<Instituicao> findInstituicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Instituicao.class));
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

    public Instituicao findInstituicao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Instituicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getInstituicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Instituicao> rt = cq.from(Instituicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
