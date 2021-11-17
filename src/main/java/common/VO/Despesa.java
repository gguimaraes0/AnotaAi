package common.VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tbDespesa")
public class Despesa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDespesa;


    private Integer cliente;
    private String descricao;
    private String valor;
    private Integer tipo;
    private String data_vencimento;
    private Integer instituicao_pagamento;

    private double pago;

    public int getIdDespesa() {
        return idDespesa;
    }
    public void setIdDespesa(int idDespesa) {
        this.idDespesa = idDespesa;
    }
    public Integer getCliente(){
        return  cliente;
    }
    public void setCliente(Integer cliente){
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
    public Integer getTipo() {
        return tipo;
    }
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public String getDatavencimento() {
        return data_vencimento;
    }
    public void setDatavencimento(String data_recebimento) {
        this.data_vencimento = data_recebimento;
    }
    public Integer getInstituicaoPagamento() {
        return instituicao_pagamento;
    }
    public void setInstituicaoPagamento(Integer instituicao_pagamento) {
        this.instituicao_pagamento = instituicao_pagamento;
    }

    public double getPago() {
        return pago;
    }
    public void setPago(double pago) {
        this.pago = pago;
    }
}