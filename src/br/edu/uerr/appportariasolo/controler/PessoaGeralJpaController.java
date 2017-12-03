/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.uerr.appportariasolo.controler;

import br.edu.uerr.appportariasolo.controler.exceptions.NonexistentEntityException;
import br.edu.uerr.appportariasolo.modelo.PessoaGeral;
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
public class PessoaGeralJpaController implements Serializable {

    public PessoaGeralJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PessoaGeral pessoaGeral) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pessoaGeral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PessoaGeral pessoaGeral) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pessoaGeral = em.merge(pessoaGeral);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pessoaGeral.getIdPessoaGeral();
                if (findPessoaGeral(id) == null) {
                    throw new NonexistentEntityException("The pessoaGeral with id " + id + " no longer exists.");
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
            PessoaGeral pessoaGeral;
            try {
                pessoaGeral = em.getReference(PessoaGeral.class, id);
                pessoaGeral.getIdPessoaGeral();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaGeral with id " + id + " no longer exists.", enfe);
            }
            em.remove(pessoaGeral);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PessoaGeral> findPessoaGeralEntities() {
        return findPessoaGeralEntities(true, -1, -1);
    }

    public List<PessoaGeral> findPessoaGeralEntities(int maxResults, int firstResult) {
        return findPessoaGeralEntities(false, maxResults, firstResult);
    }

    private List<PessoaGeral> findPessoaGeralEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PessoaGeral.class));
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

    public PessoaGeral findPessoaGeral(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PessoaGeral.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaGeralCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PessoaGeral> rt = cq.from(PessoaGeral.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaUltimoQuatro(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<PessoaGeral> listaUltimoQuatroFun(String n) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral,funcionario p where id_pessoa_geral=id_pessoa_geral_fk";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<PessoaGeral> listaNomePessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<PessoaGeral> listaCpfPessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT cpf FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }

    public List<PessoaGeral> listaRgPessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT rg FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaSexoPessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT sexo FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaCelularPessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT celular FROM pessoa_geral p where nome='" + n + "' and cpf='" + c + "'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaTipoPessoaFunc(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral,funcionario p where id_pessoa_geral=id_pessoa_geral_fk and nome='"+ n +"' and cpf='"+ c +"'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaTipoPessoaAlun(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral,aluno p where id_pessoa_geral=id_pessoa_geral_fk and nome='"+ n +"' and cpf='"+ c +"'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public List<PessoaGeral> listaTipoPessoaVis(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT nome FROM pessoa_geral,vizitante p where id_pessoa_geral=id_pessoa_geral_fk and nome='"+ n +"' and cpf='"+ c +"'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }
    }
        public List<PessoaGeral> listaIdPessoa(String n, String c) {
        EntityManager em = getEntityManager();

        try {
            //List<Pessoa> listaPessoa = new ArrayList<>();
            String sql = "SELECT id_pessoa_geral FROM pessoa_geral p where nome='"+ n +"' and cpf='"+ c +"'";

            Query q = em.createNativeQuery(sql);
            //listaPessoa = q.getResultList();

            //return listaPessoa;
            return q.getResultList();
        } finally {
            em.close();
        }

    }
}
