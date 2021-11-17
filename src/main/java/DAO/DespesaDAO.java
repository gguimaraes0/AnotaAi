    package DAO;

import common.Runtime.SessionUtil;
import common.VO.Despesa;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
    }
