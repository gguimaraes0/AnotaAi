package common.VO;
import javax.persistence.*;
import java.time.LocalDateTime;
import common.generic.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Receita")
public class Receita extends model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceita;

    @ManyToOne(optional = false)
    private Usuario usuario;

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
    public Usuario getUsuario(){
        return  usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
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