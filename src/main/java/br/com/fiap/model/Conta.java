package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_conta")
public class Conta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CONTA"
    )
    @SequenceGenerator(
            name = "SEQ_CONTA",
            sequenceName = "SEQ_CONTA",
            allocationSize = 1
    )
    private Long idConta;

    @Column(name = "numero_conta")
    private int numeroConta;

    @Column(name = "tipo_conta")
    private String tipoConta;

    private double saldo;
    private String banco;
    private int agencia;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    private String status;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;

    public Conta() {}

    public Conta(Long idConta, int numeroConta, String tipoConta,
                 String banco, int agencia, double saldo,
                 LocalDate dataAbertura, String status, Usuario usuario) {
        this.idConta = idConta;
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.agencia = agencia;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.status = status;
        this.usuario = usuario;
    }

    public Conta(int numeroConta, String tipoConta, String banco,
                 int agencia,  double saldo, Usuario usuario) {
        this.numeroConta = numeroConta;
        this.tipoConta = tipoConta;
        this.banco = banco;
        this.agencia = agencia;
        this.saldo = 0.0;
        this.status = "Ativa";
        this.usuario = usuario;
    }


    public void criarConta() {
        System.out.println("Criando conta do tipo: " + tipoConta + " no banco: " + banco);
    }

    public void consultarSaldo() {
        System.out.println("Consultando saldo da conta " + numeroConta + ": R$ " + saldo);
    }

    public void atualizarSaldo() {
        System.out.println("Atualizando saldo da conta: " + numeroConta);
    }

    public void bloquearConta() {
        this.status = "Bloqueada";
        System.out.println("Bloqueando conta: " + numeroConta);
    }

    public void vincularUsuario() {
        System.out.println("Vinculando usuário à conta: " + numeroConta);
    }

    public void gerarExtrato() {
        System.out.println("Gerando extrato da conta: " + numeroConta);
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "idConta=" + idConta +
                ", numeroConta='" + numeroConta + '\'' +
                ", tipoConta='" + tipoConta + '\'' +
                ", saldo=" + saldo +
                ", banco='" + banco + '\'' +
                ", agencia='" + agencia + '\'' +
                ", dataAbertura=" + dataAbertura +
                ", status='" + status + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
