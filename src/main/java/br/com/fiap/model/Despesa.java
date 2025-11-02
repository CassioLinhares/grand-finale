package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_despesa")
public class Despesa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_DESPESA"
    )
    @SequenceGenerator(
            name = "SEQ_DESPESA",
            sequenceName = "SEQ_DESPESA",
            allocationSize = 1
    )
    private Long idDespesa;

    @Column(name = "tipo_despesa")
    private String tipoDespesa;

    @Column(name = "nome_despesa")
    private String nomeDespesa;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_gasto")
    private LocalDate dataGasto;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Despesa() {}

    public Despesa(Long idDespesa, String tipoDespesa, String nomeDespesa, double valor, LocalDate dataGasto, Conta conta) {
        this.idDespesa = idDespesa;
        this.tipoDespesa = tipoDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        this.dataGasto = dataGasto;
        this.conta = conta;
    }

    public Despesa(String tipoDespesa, String nomeDespesa, double valor, LocalDate dataGasto, Conta conta) {
        this.tipoDespesa = tipoDespesa;
        this.nomeDespesa = nomeDespesa;
        this.valor = valor;
        this.dataGasto = dataGasto;
        this.conta = conta;
    }

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public String getTipoDespesa() {
        return tipoDespesa;
    }

    public void setTipoDespesa(String tipoDespesa) {
        this.tipoDespesa = tipoDespesa;
    }

    public String getNomeDespesa() {
        return nomeDespesa;
    }

    public void setNomeDespesa(String nomeDespesa) {
        this.nomeDespesa = nomeDespesa;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataGasto() {
        return dataGasto;
    }

    public void setDataGasto(LocalDate dataGasto) {
        this.dataGasto = dataGasto;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}