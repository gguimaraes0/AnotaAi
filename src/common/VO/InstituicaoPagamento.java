package common.VO;


import javax.persistence.*;
import common.generic.model;

@Entity(name = "InstituicaoPagamento")
public class InstituicaoPagamento extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idInstituicaoPagamento;

    private String nome;

    public int getIdInstituicaoPagamento() {
        return idInstituicaoPagamento;
    }
    public void setIdInstituicaoPagamento(int idInstituicaoPagamento) {
        this.idInstituicaoPagamento = idInstituicaoPagamento;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}