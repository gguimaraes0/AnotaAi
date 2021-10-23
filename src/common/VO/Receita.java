package common.VO;

import javax.persistence.*;
import common.generic.model;


@Entity(name = "tbReceita")
public class Receita extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceita;

    @ManyToOne(optional = false)
    private Cliente cliente;

    private String descricao;
    private String valor;

    @ManyToOne(optional = false)
    private Tipo tipo;

    private String data_recebimento;

    @ManyToOne(optional = false)
    private InstituicaoPagamento instituicao_pagamento;

    private double recebido;

    public int getIdReceita() {
        return idReceita;
    }
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }
    public Cliente getCliente(){
        return  cliente;
    }
    public void setCliente(Cliente cliente ){
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
    public String getData_recebimento() {
        return data_recebimento;
    }
    public void setData_recebimento(String data_recebimento) {
        this.data_recebimento = data_recebimento;
    }
    public InstituicaoPagamento getInstituicaoPagamento() {
        return instituicao_pagamento;
    }
    public void setInstituicaoPagamento(InstituicaoPagamento instituicao_pagamento) {
        this.instituicao_pagamento = instituicao_pagamento;
    }
    public double getRecebido() {
        return recebido;
    }
    public void setRecebido(double recebido) {
        this.recebido = recebido;
    }
}