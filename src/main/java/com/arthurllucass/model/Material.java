package com.arthurllucass.model;

import com.arthurllucass.model.enums.StatusCadastro;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer quantidadeAtual;
    private Integer quantidadeMinima;
    private Float custo;
    private Integer statusCadastro;

    public Material() {
    }

    public Material(String nome, Integer quantidadeAtual, Integer quantidadeMinima, Float custo, StatusCadastro statusCadastro) {
        this.nome = nome;
        this.quantidadeAtual = quantidadeAtual;
        this.quantidadeMinima = quantidadeMinima;
        this.custo = custo;
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

    public Integer getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(Integer quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public Integer getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(Integer quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public Float getCusto() {
        return custo;
    }

    public void setCusto(Float custo) {
        this.custo = custo;
    }

    public StatusCadastro getStatusCadastro() {
        return StatusCadastro.valueOf(statusCadastro);
    }

    public void setStatusCadastro(StatusCadastro statusCadastro) {
        if (statusCadastro != null) this.statusCadastro = statusCadastro.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
