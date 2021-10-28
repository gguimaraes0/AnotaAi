package common.VO;

import common.generic.model;
import javax.persistence.*;

@Entity(name = "tbDespesa")
public class Despesa extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespesa;

    @ManyToOne(optional = false)
    private Cliente cliente;

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
    public Cliente getCliente(){
        return  cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
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