package common.VO;
import javax.persistence.*;
import java.time.LocalDateTime;
import common.generic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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