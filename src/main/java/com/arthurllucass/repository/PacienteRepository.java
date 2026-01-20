package com.arthurllucass.repository;

import com.arthurllucass.model.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteRepository {

    Paciente salvar (Paciente paciente);
    Optional<Paciente> buscarPorId(Long id);
    List<Paciente> buscarTodos();
    Optional<Paciente> buscarPorCPF(String cpf);
    Paciente atualizar (Paciente paciente);
    void deletar (Long id);
}
