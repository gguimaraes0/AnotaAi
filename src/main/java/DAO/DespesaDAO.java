package DAO;

import common.Runtime.SessionUtil;
import common.VO.Cliente;
import common.VO.Despesa;
import common.VO.Receita;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DespesaDAO {
    public static boolean insert(Despesa newDespesa) {
        EntityManager em = SessionUtil.getSession();
        try {
            em.getTransaction().begin();
            em.persist(newDespesa);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public static List<Despesa> selectAllbyCliente(Cliente cliente) {
        try {
            EntityManager em = SessionUtil.getSession();
            Query query = em.createQuery("select c from tbDespesa c where c.cliente = :cliente", Despesa.class)
                    .setParameter("cliente", cliente);
            List<Despesa> despesas = (List<Despesa>) query.getResultList();
            return despesas;
        } catch (Exception e) {
            return null;
        }
    }
}
