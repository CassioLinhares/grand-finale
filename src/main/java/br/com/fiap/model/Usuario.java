package br.com.fiap.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_USUARIO"
    )
    @SequenceGenerator(
            name = "SEQ_USUARIO",
            sequenceName = "SEQ_USUARIO",
            allocationSize = 1
    )
    @Column(name = "id_usuario")
    private Long idUsuario;

    private String nome;

    @Column(name = "data_nasc")
    private LocalDate dataNasc;

    private String genero;

    private String telefone;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;

    @Column(name = "perfil_financeiro")
    private String perfilFinanceiro;

    private String status;

    @Column(name = "data_ultimo_login")
    private LocalDate dataUltimoLogin;

    private String senha;

    public Usuario() {}

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String nome, LocalDate dataNasc, String genero, String telefone, String email, String perfilFinanceiro, String status, LocalDate dataUltimoLogin, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.perfilFinanceiro = perfilFinanceiro;
        this.status = status;
        this.dataUltimoLogin = dataUltimoLogin;
        this.senha = senha;
    }

    public Usuario(String nome, LocalDate dataNasc, String genero, String telefone, String email, String perfilFinanceiro, String status, LocalDate dataUltimoLogin, String senha) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.perfilFinanceiro = perfilFinanceiro;
        this.status = status;
        this.dataUltimoLogin = dataUltimoLogin;
        this.senha = senha;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfilFinanceiro() {
        return perfilFinanceiro;
    }

    public void setPerfilFinanceiro(String perfilFinanceiro) {
        this.perfilFinanceiro = perfilFinanceiro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public void setDataUltimoLogin(LocalDate dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}