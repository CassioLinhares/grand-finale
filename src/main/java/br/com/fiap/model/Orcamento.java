package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_orcamento")
public class Orcamento {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_ORCAMENTO"
    )
    @SequenceGenerator(
            name = "SEQ_ORCAMENTO",
            sequenceName = "SEQ_ORCAMENTO",
            allocationSize = 1

    )
    @Column(name = "id_orcamento")
    private Long idOrcamento;

    @Column(name = "tipo_orcamento")
    private String tipoOrcamento;

    @Column(name = "valor_planejado")
    private double valorPlanejado;

    @Column(name = "valor_utilizado")
    private double valorUtilizado;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Orcamento() {}

    public Orcamento(Long idOrcamento, String tipoOrcamento, double valorPlanejado, double valorUtilizado, LocalDate dataInicio, LocalDate dataFim, Conta conta) {
        this.idOrcamento = idOrcamento;
        this.tipoOrcamento = tipoOrcamento;
        this.valorPlanejado = valorPlanejado;
        this.valorUtilizado = valorUtilizado;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.conta = conta;
    }

    public Orcamento(String tipoOrcamento, double valorPlanejado, double valorUtilizado, LocalDate dataInicio, LocalDate dataFim, Conta conta) {
        this.tipoOrcamento = tipoOrcamento;
        this.valorPlanejado = valorPlanejado;
        this.valorUtilizado = valorUtilizado;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.conta = conta;
    }

    public Long getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Long idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public String getTipoOrcamento() {
        return tipoOrcamento;
    }

    public void setTipoOrcamento(String tipoOrcamento) {
        this.tipoOrcamento = tipoOrcamento;
    }

    public double getValorPlanejado() {
        return valorPlanejado;
    }

    public void setValorPlanejado(double valorPlanejado) {
        this.valorPlanejado = valorPlanejado;
    }

    public double getValorUtilizado() {
        return valorUtilizado;
    }

    public void setValorUtilizado(double valorUtilizado) {
        this.valorUtilizado = valorUtilizado;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
