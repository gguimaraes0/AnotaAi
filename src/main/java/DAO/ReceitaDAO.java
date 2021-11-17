    package DAO;

import common.Runtime.SessionUtil;
import common.VO.Receita;

import javax.persistence.EntityManager;

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
    }
