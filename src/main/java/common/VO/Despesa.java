package common.VO;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tbDespesa")
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespesa;

    @ManyToOne
    @JoinColumn(name="cliente_id")
    private Cliente cliente_id;

    @ManyToOne
    @JoinColumn(name="tipo_idTipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name="instituicao_pagamento_idInstituicaoPagamento")
    private InstituicaoPagamento instituicao_pagamento;

    private String descricao;
    private String valor;
    private String data_vencimento;

    private double pago;

    public int getIdDespesa() {
        return idDespesa;
    }
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
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

    public String getDatavencimento() {
        return data_vencimento;
    }
    public void setDatavencimento(String data_recebimento) {
        this.data_vencimento = data_recebimento;
    }


    public Cliente getCliente_id() {
        return cliente_id;
    }
    public void setCliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    public InstituicaoPagamento getInstituicaoPagamento() {
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