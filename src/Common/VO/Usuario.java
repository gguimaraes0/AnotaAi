package Common.VO;
import Common.generic.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Usuarios")
public class User extends model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;

    @Column(unique = true)
    private String email;
    private String password;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//    public Despesa getDespesa() {
//        return despesa;
//    }
//    public void setDespesa(Despesa despesa) {
//        this.despesa = despesa;
//    }
//    public Receita getReceita() {
//        return receita;
//    }
//    public void setReceita(Receita receita) {
//        this.receita = receita;
//    }
}