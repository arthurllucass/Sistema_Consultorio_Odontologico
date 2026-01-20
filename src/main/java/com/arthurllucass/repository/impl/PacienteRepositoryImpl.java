package com.arthurllucass.repository.impl;

import com.arthurllucass.model.entity.Paciente;
import com.arthurllucass.repository.PacienteRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PacienteRepositoryImpl implements PacienteRepository {

    private final EntityManager em;

    public PacienteRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Paciente salvar(Paciente paciente) {
        try {
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
            return paciente;

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar o paciente!", erro);
        }
    }

    @Override
    public Optional<Paciente> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Paciente.class,id));
    }

    @Override
    public List<Paciente> buscarTodos() {
        return em.createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
    }

    @Override
    public Optional<Paciente> buscarPorCPF(String cpf) {
        try {
            TypedQuery<Paciente> query = em.createQuery("SELECT paciente FROM Paciente paciente WHERE paciente.cpf = :cpf ", Paciente.class);
            query.setParameter("cpf", cpf);

            return Optional.of(query.getSingleResult());

        } catch (NoResultException erro) {
            return Optional.empty();
        }
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        try {
            em.getTransaction().begin();
            em.merge(paciente);
            em.getTransaction().commit();
            return paciente;

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao atualizar o paciente!", erro);
        }
    }

    @Override
    public void deletar(Long id) {
        try {
            em.getTransaction().begin();

            if (em.find(Paciente.class, id) != null) em.remove(em.find(Paciente.class, id));
            em.getTransaction().commit();

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw  new RuntimeException("Erro ao deletar o paciente!", erro);
        }
    }
}
