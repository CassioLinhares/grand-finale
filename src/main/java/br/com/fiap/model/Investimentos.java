package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_investimento")
public class Investimentos {
        @Id
        @GeneratedValue(
                strategy = GenerationType.SEQUENCE,
                generator = "SEQ_INVESTIMENTO"
        )
        @SequenceGenerator(
                name = "SEQ_INVESTIMENTO",
                sequenceName = "SEQ_INVESTIMENTO",
                allocationSize = 1
        )
    private Long id_investimento;
    private String tipo_investimento;
    private double valor;
    private double rentabilidade;
    private LocalDate data_retirada_aplicacao;
    private double valor_atual;
    private LocalDate data_aplicacao;
    private String nome_instituicao;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Investimentos() {}

    public Investimentos(Long id_investimento, String tipo_investimento, double valor, double rentabilidade, LocalDate data_retirada_aplicacao, double valor_atual, LocalDate data_aplicacao, String nome_instituicao, Conta conta) {
        this.id_investimento = id_investimento;
        this.tipo_investimento = tipo_investimento;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.data_retirada_aplicacao = data_retirada_aplicacao;
        this.valor_atual = valor_atual;
        this.data_aplicacao = data_aplicacao;
        this.nome_instituicao = nome_instituicao;
        this.conta = conta;
    }

    public Investimentos(String tipo_investimento, double valor, double rentabilidade, LocalDate data_retirada_aplicacao, double valor_atual, LocalDate data_aplicacao, String nome_instituicao, Conta conta) {
        this.tipo_investimento = tipo_investimento;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.data_retirada_aplicacao = data_retirada_aplicacao;
        this.valor_atual = valor_atual;
        this.data_aplicacao = data_aplicacao;
        this.nome_instituicao = nome_instituicao;
        this.conta = conta;
    }

    public Long getId_investimento() {
        return id_investimento;
    }

    public void setId_investimento(Long id_investimento) {
        this.id_investimento = id_investimento;
    }

    public String getTipo_investimento() {
        return tipo_investimento;
    }

    public void setTipo_investimento(String tipo_investimento) {
        this.tipo_investimento = tipo_investimento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getRentabilidade() {
        return rentabilidade;
    }

    public void setRentabilidade(double rentabilidade) {
        this.rentabilidade = rentabilidade;
    }

    public LocalDate getData_retirada_aplicacao() {
        return data_retirada_aplicacao;
    }

    public void setData_retirada_aplicacao(LocalDate data_retirada_aplicacao) {
        this.data_retirada_aplicacao = data_retirada_aplicacao;
    }

    public double getValor_atual() {
        return valor_atual;
    }

    public void setValor_atual(double valor_atual) {
        this.valor_atual = valor_atual;
    }

    public LocalDate getData_aplicacao() {
        return data_aplicacao;
    }

    public void setData_aplicacao(LocalDate data_aplicacao) {
        this.data_aplicacao = data_aplicacao;
    }

    public String getNome_instituicao() {
        return nome_instituicao;
    }

    public void setNome_instituicao(String nome_instituicao) {
        this.nome_instituicao = nome_instituicao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    //to usando esse pois no InvestimentosView ele não trazia um @101639ae, mas eu queria os dados por escrito
    @Override
    public String toString() {
        return "Investimentos{" +
                "id_investimento=" + id_investimento +
                ", tipo_investimento='" + tipo_investimento + '\'' +
                ", valor=" + valor +
                ", data_aplicacao=" + data_aplicacao +
                ", nome_instituicao='" + nome_instituicao + '\'' +
                ", conta=" + conta +
                '}';
    }

}

