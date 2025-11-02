package br.com.fiap.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_investimento")
public class Investimento {
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
    @Column(name = "idInvestimento")
    private Long idInvestimento;
    @Column(name = "nome_investimento")
    private String nomeInvestimento;
    @Column(name = "tipo_investimento")
    private String tipoInvestimento;
    private double valor;
    private double rentabilidade;
    @Column(name = "data_retirada_aplicacao")
    private LocalDate dataRetiradaAplicacao;
    @Column(name = "valor_atual")
    private double valorAtual;
    @Column(name = "data_aplicacao")
    private LocalDate dataAplicacao;
    @Column(name = "nome_instituicao")
    private String nomeInstituicao;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Investimento() {
    }

    public Investimento(Long idInvestimento, String nomeInvestimento, String tipoInvestimento, double valor, double rentabilidade, LocalDate dataRetiradaAplicacao, double valorAtual, LocalDate dataAplicacao, String nomeInstituicao, Conta conta) {
        this.idInvestimento = idInvestimento;
        this.nomeInvestimento = nomeInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.dataRetiradaAplicacao = dataRetiradaAplicacao;
        this.valorAtual = valorAtual;
        this.dataAplicacao = dataAplicacao;
        this.nomeInstituicao = nomeInstituicao;
        this.conta = conta;
    }

    public Investimento(String nomeInvestimento, String tipoInvestimento, double valor, double rentabilidade, LocalDate dataRetiradaAplicacao, double valorAtual, LocalDate dataAplicacao, String nomeInstituicao, Conta conta) {
        this.nomeInvestimento = nomeInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valor = valor;
        this.rentabilidade = rentabilidade;
        this.dataRetiradaAplicacao = dataRetiradaAplicacao;
        this.valorAtual = valorAtual;
        this.dataAplicacao = dataAplicacao;
        this.nomeInstituicao = nomeInstituicao;
        this.conta = conta;
    }

    public Long getId_investimento() {
        return idInvestimento;
    }

    public void setId_investimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getNomeInvestimento() {
        return nomeInvestimento;
    }

    public void setNomeInvestimento(String nomeInvestimento) {
        this.nomeInvestimento = nomeInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
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

    public LocalDate getDataRetiradaAplicacao() {
        return dataRetiradaAplicacao;
    }

    public void setDataRetiradaAplicacao(LocalDate dataRetiradaAplicacao) {
        this.dataRetiradaAplicacao = dataRetiradaAplicacao;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
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
                "id_investimento=" + idInvestimento +
                ", tipo_investimento='" + tipoInvestimento + '\'' +
                ", valor=" + valor +
                ", data_aplicacao=" + dataAplicacao +
                ", nome_instituicao='" + nomeInstituicao + '\'' +
                ", nome_investimento='" + nomeInvestimento + '\'' +
                ", conta=" + conta +
                '}';
    }

}

