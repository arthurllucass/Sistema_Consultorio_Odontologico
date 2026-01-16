package com.arthurllucass.model;

import com.arthurllucass.model.enums.StatusCadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Procedimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Float duracaoMinutos;
    private Float valor;
    private Integer statusCadastro;

    public Procedimento (String nome, Float duracaoMinutos, Float valor, StatusCadastro statusCadastro) {
        this.nome = nome;
        this.duracaoMinutos = duracaoMinutos;
        this.valor = valor;
        setStatusCadastro(statusCadastro);
    }

    public Procedimento() {
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

    public Float getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(Float duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public StatusCadastro getStatusCadastro() {
        return StatusCadastro.valueOf(statusCadastro);
    }

    public void setStatusCadastro(StatusCadastro statusCadastro) {
        if (statusCadastro != null)  this.statusCadastro = statusCadastro.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Procedimento that = (Procedimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
