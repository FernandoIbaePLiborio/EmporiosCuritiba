package com.emporios.enums;

public enum NivelAcesso
{
    ADMINISTRADOR('A'), CLIENTE('C'), LOJA('L'), FUNCIONARIO('F');

    // Atributo
    private char codigo;

    // Construtores
    private NivelAcesso(char pCodigo)
    {
        codigo = pCodigo;
    }

    // Métodos estáticos
    public static NivelAcesso fromChar(char pCodigo)
    {
        NivelAcesso[] tNivel = values();

        for (NivelAcesso tNivelUsuario : tNivel)
        {
            if (pCodigo == tNivelUsuario.codigo)
                return tNivelUsuario;
        }

        return null;
    }

    // Métodos normais
    public char getCodigo()
    {
        return codigo;
    }
}
