/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import br.edu.uerr.appportariasolo.modelo.Portaria;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Diego_Note
 */
public class PortariaJpaController implements Serializable {

    public PortariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Portaria portaria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(portaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Portaria portaria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            portaria = em.merge(portaria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = portaria.getIdPortaria();
                if (findPortaria(id) == null) {
                    throw new NonexistentEntityException("The portaria with id " + id + " no longer exists.");
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
            Portaria portaria;
            try {
                portaria = em.getReference(Portaria.class, id);
                portaria.getIdPortaria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The portaria with id " + id + " no longer exists.", enfe);
            }
            em.remove(portaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Portaria> findPortariaEntities() {
        return findPortariaEntities(true, -1, -1);
    }

    public List<Portaria> findPortariaEntities(int maxResults, int firstResult) {
        return findPortariaEntities(false, maxResults, firstResult);
    }

    private List<Portaria> findPortariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Portaria.class));
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

    public Portaria findPortaria(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Portaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getPortariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Portaria> rt = cq.from(Portaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Portaria> listaDataEntrada(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT data_hora_entrada FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaDataSaida(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT data_hora_saida FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_saida >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaDescricao(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT descricao FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaTipo(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT descricao FROM pessoa_geral,portaria p where nome='" + n + "' and cpf='" + c + "'and data_hora_saida >= '" + d + "'order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaNome(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaCpf(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT cpf FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaIdPortaria(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT id_portaria FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<Portaria> listaIdPessoaGeralPortaria(String n, String c, String d) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT portaria.id_pessoa_geral FROM pessoa_geral,portaria where nome='" + n + "' and cpf='" + c + "'and data_hora_entrada >= '" + d + "'and pessoa_geral.id_pessoa_geral=portaria.id_pessoa_geral order by id_portaria desc limit 1";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

}
