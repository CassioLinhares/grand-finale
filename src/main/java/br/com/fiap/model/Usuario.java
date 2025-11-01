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
    private Long id_usuario;
    private String nome;
    private LocalDate data_nasc;
    private String genero;
    private int telefone;

    @Column(unique = true)
    @Email
    @NotBlank
    private String email;
    private String perfil_financeiro;
    private String status;
    private LocalDate data_ultimo_login;
    private String senha;

    public Usuario() {}

    public Usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(Long id_usuario, String nome, LocalDate data_nasc, String genero, int telefone, String email, String perfil_financeiro, String status, LocalDate data_ultimo_login, String senha) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.perfil_financeiro = perfil_financeiro;
        this.status = status;
        this.data_ultimo_login = data_ultimo_login;
        this.senha = senha;
    }

    public Usuario(String nome, LocalDate data_nasc, String genero, int telefone, String email, String perfil_financeiro, String status, LocalDate data_ultimo_login, String senha) {
        this.nome = nome;
        this.data_nasc = data_nasc;
        this.genero = genero;
        this.telefone = telefone;
        this.email = email;
        this.perfil_financeiro = perfil_financeiro;
        this.status = status;
        this.data_ultimo_login = data_ultimo_login;
        this.senha = senha;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(LocalDate data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil_financeiro() {
        return perfil_financeiro;
    }

    public void setPerfil_financeiro(String perfil_financeiro) {
        this.perfil_financeiro = perfil_financeiro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getData_ultimo_login() {
        return data_ultimo_login;
    }

    public void setData_ultimo_login(LocalDate data_ultimo_login) {
        this.data_ultimo_login = data_ultimo_login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}



