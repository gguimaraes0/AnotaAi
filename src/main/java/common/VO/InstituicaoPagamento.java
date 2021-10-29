package common.VO;


import javax.persistence.*;

import java.io.Serializable;

@Entity(name = "tbInstituicaoPagamento")
public class InstituicaoPagamento implements Serializable {
    private static final long serialVersionUID = 1L;

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