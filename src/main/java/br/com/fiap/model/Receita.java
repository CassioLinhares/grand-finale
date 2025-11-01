package br.com.fiap.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_receita")
public class Receita {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_RECEITA"
    )
    @SequenceGenerator(
            name = "SEQ_RECEITA",
            sequenceName = "SEQ_RECEITA",
            allocationSize = 1
    )
    private Long idReceita;

    @Column(name = "valor_receita")
    private double valorReceita;

    @Column(name = "tipo_receita")
    private String tipoReceita;
    private String descricao;

    @Column(name = "data_emissao")
    private LocalDate dataEmissao;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Receita() {}

    public Receita(Long idReceita, double valorReceita, String tipoReceita, String descricao, LocalDate dataEmissao, Conta conta) {
        this.idReceita = idReceita;
        this.valorReceita = valorReceita;
        this.tipoReceita = tipoReceita;
        this.descricao = descricao;
        this.dataEmissao = dataEmissao;
        this.conta = conta;
    }

    public Receita(double valorReceita, String tipoReceita, String descricao, LocalDate dataEmissao, Conta conta) {
        this.valorReceita = valorReceita;
        this.tipoReceita = tipoReceita;
        this.descricao = descricao;
        this.dataEmissao = dataEmissao;
        this.conta = conta;
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public double getValorReceita() {
        return valorReceita;
    }

    public void setValorReceita(double valorReceita) {
        this.valorReceita = valorReceita;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
