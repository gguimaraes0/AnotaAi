package common.VO;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "tbReceita")
public class Receita implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReceita;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_idTipo")
    private Tipo tipo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instituicao_pagamento_idInstituicaoPagamento")
    private InstituicaoPagamento instituicao_pagamento;

    private String data_recebimento;
    private String descricao;
    private String valor;
    private double recebido;

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor() {
        return valor;
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