package DAO;

import common.Runtime.SessionUtil;
import common.VO.Cliente;
import common.VO.Receita;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ReceitaDAO {
    public static boolean insert(Receita newReceita) {
        EntityManager em = SessionUtil.getSession();
        try {
            em.getTransaction().begin();
            em.persist(newReceita);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public static List<Receita> selectAllbyCliente(Cliente cliente) {
        try {
            EntityManager em = SessionUtil.getSession();
            Query query = em.createQuery("select c from tbReceita c where c.cliente = :cliente", Receita.class)
                    .setParameter("cliente", cliente);
            List<Receita> receitas = (List<Receita>) query.getResultList();
            return receitas;
        } catch (Exception e) {
            return null;
        }
    }
}
