package common.VO;
import javax.persistence.*;
import java.time.LocalDateTime;
import common.generic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Tipo")
public class Tipo extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;

    private String nome;

    public int getIdTipo() {
        return idTipo;
    }
    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}