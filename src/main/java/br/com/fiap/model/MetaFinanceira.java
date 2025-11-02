package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_meta_financeira")
public class MetaFinanceira {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_META_FINANCEIRA"
    )
    @SequenceGenerator(
            name = "SEQ_META_FINANCEIRA",
            sequenceName = "SEQ_META_FINANCEIRA",
            allocationSize = 1
    )
    @Column(name = "id_meta_financeira")
    private Long idMetaFinanceira;

    @Column(name = "nome_meta_financeira")
    private String nomeMetaFinanceira;

    @Column(name = "tipo_meta_financeira")
    private String tipoMetaFinanceira;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "valor_objetivo")
    private double valorObjetivo;

    @Column(name = "valor_atual")
    private double valorAtual;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @Column(name = "data_conclusao")
    private LocalDate dataConclusao;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public MetaFinanceira() {}

    public MetaFinanceira(Long idMetaFinanceira, String nomeMetaFinanceira, String tipoMetaFinanceira, String descricao, double valorObjetivo, double valorAtual, LocalDate dataCriacao, LocalDate dataConclusao, Conta conta) {
        this.idMetaFinanceira = idMetaFinanceira;
        this.nomeMetaFinanceira = nomeMetaFinanceira;
        this.tipoMetaFinanceira = tipoMetaFinanceira;
        this.descricao = descricao;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.conta = conta;
    }

    public MetaFinanceira(String nomeMetaFinanceira, String tipoMetaFinanceira, String descricao, double valorObjetivo, double valorAtual, LocalDate dataCriacao, LocalDate dataConclusao, Conta conta) {
        this.nomeMetaFinanceira = nomeMetaFinanceira;
        this.tipoMetaFinanceira = tipoMetaFinanceira;
        this.descricao = descricao;
        this.valorObjetivo = valorObjetivo;
        this.valorAtual = valorAtual;
        this.dataCriacao = dataCriacao;
        this.dataConclusao = dataConclusao;
        this.conta = conta;
    }

    public Long getIdMetaFinanceira() {
        return idMetaFinanceira;
    }

    public void setIdMetaFinanceira(Long idMetaFinanceira) {
        this.idMetaFinanceira = idMetaFinanceira;
    }

    public String getNomeMetaFinanceira() {
        return nomeMetaFinanceira;
    }

    public void setNomeMetaFinanceira(String nomeMetaFinanceira) {
        this.nomeMetaFinanceira = nomeMetaFinanceira;
    }

    public String getTipoMetaFinanceira() {
        return tipoMetaFinanceira;
    }

    public void setTipoMetaFinanceira(String tipoMetaFinanceira) {
        this.tipoMetaFinanceira = tipoMetaFinanceira;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(double valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public double getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(double valorAtual) {
        this.valorAtual = valorAtual;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}