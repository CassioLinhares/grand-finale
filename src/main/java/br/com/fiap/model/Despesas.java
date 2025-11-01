package br.com.fiap.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_despesa")
public class Despesas {

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
    private Long id_despesas;
    private Usuario usuario;
    private int tipo_despesas;
    private String nome_despesa;
    private double valor;

    @Column(name = "data_gasto")
    private LocalDate dataGasto;

    @ManyToOne
    @JoinColumn(name = "idConta", referencedColumnName = "idConta")
    private Conta conta;

    public Despesas() {}

    public Despesas(Long id_despesas, Usuario usuario, int tipo_despesas, String nome_despesa, double valor, LocalDate dataGasto, Conta conta) {
        this.id_despesas = id_despesas;
        this.usuario = usuario;
        this.tipo_despesas = tipo_despesas;
        this.nome_despesa = nome_despesa;
        this.valor = valor;
        this.dataGasto = dataGasto;
        this.conta = conta;
    }

    public Despesas(Usuario usuario, int tipo_despesas, String nome_despesa, double valor, LocalDate dataGasto, Conta conta) {
        this.usuario = usuario;
        this.tipo_despesas = tipo_despesas;
        this.nome_despesa = nome_despesa;
        this.valor = valor;
        this.dataGasto = dataGasto;
        this.conta = conta;
    }

    public Long getId_despesas() {
        return id_despesas;
    }

    public void setId_despesas(Long id_despesas) {
        this.id_despesas = id_despesas;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getTipo_despesas() {
        return tipo_despesas;
    }

    public void setTipo_despesas(int tipo_despesas) {
        this.tipo_despesas = tipo_despesas;
    }

    public String getNome_despesa() {
        return nome_despesa;
    }

    public void setNome_despesa(String nome_despesa) {
        this.nome_despesa = nome_despesa;
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