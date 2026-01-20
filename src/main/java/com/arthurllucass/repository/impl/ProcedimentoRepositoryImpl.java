package com.arthurllucass.repository.impl;

import com.arthurllucass.model.entity.Procedimento;
import com.arthurllucass.repository.ProcedimentoRepository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ProcedimentoRepositoryImpl implements ProcedimentoRepository {

    private EntityManager em;

    public ProcedimentoRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Procedimento salvar(Procedimento procedimento) {
        try {
            em.getTransaction().begin();
            em.persist(procedimento);
            em.getTransaction().commit();
            return procedimento;

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao salvar o procedimento!", erro);
        }
    }

    @Override
    public Optional<Procedimento> buscarPorId(Long id) {
        return Optional.ofNullable(em.find(Procedimento.class, id));
    }

    @Override
    public List<Procedimento> buscarTodos() {
        return em.createQuery("SELECT p FROM Procedimento p", Procedimento.class).getResultList();
    }

    @Override
    public Optional<Procedimento> buscarPorNome(String nome) {
        try {
            TypedQuery<Procedimento> query = em.createQuery("SELECT p FROM Procedimento p WHERE p.nome = :nome", Procedimento.class);
            query.setParameter("nome", nome);

            return Optional.ofNullable(query.getSingleResult());

        } catch (NoResultException erro) {
            return Optional.empty();
        }
    }

    @Override
    public Procedimento atualizar(Procedimento procedimento) {
        try {
            em.getTransaction().begin();
            em.merge(procedimento);
            em.getTransaction().commit();
            return procedimento;

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao atualizar o procedimento!", erro);
        }
    }

    @Override
    public void deletar(Procedimento procedimento) {
        try {
            em.getTransaction().begin();
            if(em.find(Procedimento.class, procedimento.getId()) != null) em.remove(procedimento);
            em.getTransaction().commit();

        } catch (Exception erro) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erro ao deletar o procedimento!", erro);
        }
    }
}
