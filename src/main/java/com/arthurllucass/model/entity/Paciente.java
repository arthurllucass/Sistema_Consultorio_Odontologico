package com.arthurllucass.model.entity;

import com.arthurllucass.model.enums.StatusCadastro;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String observacao;
    private Integer statusCadastro;

    public Paciente() {
    }

    public Paciente(String nome, String cpf, String telefone, String email, LocalDate dataNascimento, String observacao, StatusCadastro statusCadastro) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.observacao = observacao;
        setStatusCadastro(statusCadastro);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public StatusCadastro getStatusCadastro() {
        return StatusCadastro.valueOf(statusCadastro);
    }

    public void setStatusCadastro(StatusCadastro statusCadastro) {
        if (statusCadastro != null) this.statusCadastro = statusCadastro.getCodigo();
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paciente paciente = (Paciente) o;
        return Objects.equals(id, paciente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
