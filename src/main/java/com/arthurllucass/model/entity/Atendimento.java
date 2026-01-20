package com.arthurllucass.model.entity;

import com.arthurllucass.model.enums.StatusAtendimento;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Atendimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_agendamento")
    private Agendamento agendamento;

    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String observacoesClinicas;
    private Integer statusAtendimento;

    public Atendimento() {
    }

    public Atendimento(Agendamento agendamento, LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim, String observacoesClinicas, StatusAtendimento statusAtendimento) {
        this.agendamento = agendamento;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.observacoesClinicas = observacoesClinicas;
        setStatusAtendimento(statusAtendimento);
    }

    public Long getId() {
        return id;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public LocalDateTime getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public LocalDateTime getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(LocalDateTime dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
    }

    public String getObservacoesClinicas() {
        return observacoesClinicas;
    }

    public void setObservacoesClinicas(String observacoesClinicas) {
        this.observacoesClinicas = observacoesClinicas;
    }

    public StatusAtendimento getStatusAtendimento()  {return StatusAtendimento.valueOf(statusAtendimento);
    }

    public void setStatusAtendimento(StatusAtendimento statusAtendimento) {
        if (statusAtendimento != null) this.statusAtendimento = statusAtendimento.getCodigo();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
