package Common.VO;
import Common.generic.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "InstituicaoPagamento")
public class Despesa extends model {

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