package Common.VO;
import Common.generic.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Tipo")
public class Despesa extends model {

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