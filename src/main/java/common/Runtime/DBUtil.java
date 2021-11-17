package common.Runtime;

import common.VO.InstituicaoPagamento;
import common.VO.Tipo;
import common.VO.Cliente;

import javax.persistence.EntityManager;
public class DBUtil {

    public static void criaDB() {
        criaCliente();
        criaInstituicaoPagamento();
        criaTipo();
    }

    private static void criaTipo() {
        EntityManager em = SessionUtil.getSession();
        try {
            Tipo luz = new Tipo();
            luz.setIdTipo(1);
            luz.setNome("Luz");

            Tipo agua = new Tipo();
            agua.setIdTipo(2);
            agua.setNome("Água");

            Tipo telefone = new Tipo();
            telefone.setIdTipo(2);
            telefone.setNome("Telefone");

            Tipo internet = new Tipo();
            internet.setIdTipo(3);
            internet.setNome("Internet");

            Tipo salario = new Tipo();
            salario.setIdTipo(4);
            salario.setNome("Salário");

            Tipo invest = new Tipo();
            invest.setIdTipo(5);
            invest.setNome("Investimentos");

            Tipo outros = new Tipo();
            invest.setIdTipo(6);
            invest.setNome("Outros");


            em.getTransaction().begin();
            em.merge(luz);
            em.merge(agua);
            em.merge(telefone);
            em.merge(internet);
            em.merge(salario);
            em.merge(invest);
            em.merge(outros);

            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    private static void criaInstituicaoPagamento() {
        EntityManager em = SessionUtil.getSession();
        try {
            InstituicaoPagamento itau = new InstituicaoPagamento();
            itau.setIdInstituicaoPagamento(1);
            itau.setNome("Ítau");

            InstituicaoPagamento bb = new InstituicaoPagamento();
            bb.setIdInstituicaoPagamento(2);
            bb.setNome("Banco do Brasil");

            InstituicaoPagamento ce = new InstituicaoPagamento();
            ce.setIdInstituicaoPagamento(3);
            ce.setNome("Caixa Econômica");

            InstituicaoPagamento santander = new InstituicaoPagamento();
            santander.setIdInstituicaoPagamento(4);
            santander.setNome("Santander");

            InstituicaoPagamento nubank = new InstituicaoPagamento();
            nubank.setIdInstituicaoPagamento(5);
            nubank.setNome("Nubank");

            InstituicaoPagamento inter = new InstituicaoPagamento();
            inter.setIdInstituicaoPagamento(6);
            inter.setNome("Inter");

            InstituicaoPagamento bradesco = new InstituicaoPagamento();
            bradesco.setIdInstituicaoPagamento(7);
            bradesco.setNome("Bradesco");

            InstituicaoPagamento safra = new InstituicaoPagamento();
            safra.setIdInstituicaoPagamento(8);
            safra.setNome("Banco Safra");

            InstituicaoPagamento pan = new InstituicaoPagamento();
            pan.setIdInstituicaoPagamento(9);
            pan.setNome("Banco PAN");

            em.getTransaction().begin();
            em.merge(itau);
            em.merge(bb);
            em.merge(ce);
            em.merge(santander);
            em.merge(nubank);
            em.merge(inter);
            em.merge(bradesco);
            em.merge(safra);
            em.merge(pan);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    private static void criaCliente() {
        EntityManager em = SessionUtil.getSession();
        try {
            Cliente dev = new Cliente();
            dev.setnome("dev");
            dev.setEmail("dev@dev.com");
            dev.setPassword("123456");

            em.getTransaction().begin();
            em.merge(dev);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
}