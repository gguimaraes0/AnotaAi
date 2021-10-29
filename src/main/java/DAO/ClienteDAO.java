    package DAO;

import com.mysql.cj.xdevapi.Client;
import common.Runtime.SessionUtil;
import common.VO.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ClienteDAO {
    public static boolean insert(Cliente newCliente) {
        EntityManager em = SessionUtil.getSession();
        try {
            em.getTransaction().begin();
            em.persist(newCliente);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    
    public static Cliente selectByEmail(String email) {
        try {
            EntityManager em = SessionUtil.getSession();
            Query query = em.createQuery("select c from tbCliente c where c.email = :email", Cliente.class)
                    .setParameter("email", email);
            Cliente cliente = (Cliente) query.getSingleResult();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }
}
