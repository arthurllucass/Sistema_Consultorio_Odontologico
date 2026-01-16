package com.arthurllucass.model.enums;

public enum StatusAtendimento {
    EM_ANDAMENTO(1),
    FINALIZADO(2);

    private int codigo;

    StatusAtendimento(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusAtendimento valueOf(int codigo) {
        for (StatusAtendimento statusAtendimento : StatusAtendimento.values()) {
            if (statusAtendimento.codigo == codigo) {
                return statusAtendimento;
            }
        }
        throw new IllegalArgumentException("Código de status de atendimento é inválido!");
    }
}
