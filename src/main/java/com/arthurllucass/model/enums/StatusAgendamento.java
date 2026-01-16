package com.arthurllucass.model.enums;

public enum StatusAgendamento {
    AGENDADO(1),
    CANCELADO(2),
    FALTA(3),
    REALIZADO(4);

    private int codigo;

    StatusAgendamento(Integer codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusAgendamento valueOf(int codigo) {
        for (StatusAgendamento statusAgendamento : StatusAgendamento.values()) {
            if (statusAgendamento.getCodigo() == codigo) {
                return statusAgendamento;
            }
        }
        throw new IllegalArgumentException("Código de status de agendamento é inválido!");
    }
}
