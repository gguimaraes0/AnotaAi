package Common.VO;
import Common.generic.model;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "Despesa")
public class Despesa extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespesa;

    @ManyToOne(optional = false)
    private Usuario usuario;

    private String descricao;
    private String valor;

    @ManyToOne(optional = false)
    private Tipo tipo;

    private String data_vencimento;

    @ManyToOne(optional = false)
    private InstituicaoPagamento instituicao_pagamento;

    private double pago;

    public int getIdDespesa() {
        return idDespesa;
    }
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }
    public Usuario getIdUsuario(){
        return  usuario;
    }
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    public String getDescricao(){
        return descricao;
    }
    public void  setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getValor(){
        return  valor;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public String getData_recebimento() {
        return data_recebimento;
    }
    public void setData_recebimento(String data_recebimento) {
        this.data_recebimento = data_recebimento;
    }
    public int getInstituicaoPagamento() {
        return instituicao_pagamento;
    }
    public void setInstituicaoPagamento(InstituicaoPagamento instituicao_pagamento) {
        this.instituicao_pagamento = instituicao_pagamento;
    }
    public double getPago() {
        return pago;
    }
    public void setPago(double pago) {
        this.pago = pago;
    }
}