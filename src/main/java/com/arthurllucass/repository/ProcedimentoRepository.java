package com.arthurllucass.repository;

import com.arthurllucass.model.entity.Procedimento;

import java.util.List;
import java.util.Optional;

public interface ProcedimentoRepository {

    Procedimento salvar(Procedimento procedimento);
    Optional<Procedimento> buscarPorId(Long id);
    List<Procedimento> buscarTodos();
    Optional<Procedimento> buscarPorNome(String nome);
    Procedimento atualizar(Procedimento procedimento);
    void deletar(Procedimento procedimento);
}
