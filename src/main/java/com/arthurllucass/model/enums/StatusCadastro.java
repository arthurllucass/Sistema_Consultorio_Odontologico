package com.arthurllucass.model.enums;

public enum StatusCadastro {
    ATIVO(1),
    INATIVO(2);

    private int codigo;

    StatusCadastro(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static StatusCadastro valueOf(int codigo) {
        for (StatusCadastro statusCadastro : StatusCadastro.values()) {
            if (statusCadastro.getCodigo() == codigo) {
                return statusCadastro;
            }
        }
        throw new IllegalArgumentException("Código de status de cadastro é inválido!");
    }
}
