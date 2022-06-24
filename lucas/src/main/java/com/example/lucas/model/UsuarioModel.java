package com.example.lucas.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.function.Function;

@Entity
@Table(name = "cliente")
public class UsuarioModel implements Serializable {

    private static final long	serialVersionUID	= 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome_cliente",length = 120, nullable = false)
    private String nome;

   @Column(name = "email",length = 120, nullable = false )
    private String email;

   @Column(name = "cpf",length = 11, nullable = false, unique = true)
    private String cpf;

   @Column(name = "senha",length = 20, nullable = false)
    private String senha;

    @Column(name = "data_nascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "sexo",length = 10, nullable = false)
    private String sexo;

    public UsuarioModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioModel(String cpf) {
        this.cpf = cpf;
    }

    public UsuarioModel(String nome, String email, String cpf, String senha, Date dataNascimento, String sexo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}