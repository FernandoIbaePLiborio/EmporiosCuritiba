package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.Funcionario;

@XmlRootElement(name = "FuncionarioDTO")
public class FuncionarioDTO extends AbstractDTO<Funcionario>
{

	/* Construtores da classe */
    public FuncionarioDTO()
    {
        super();
    }

    public FuncionarioDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public FuncionarioDTO(boolean pOk, String pMensagem, Funcionario pFuncionario)
    {
        super(pOk, pMensagem, pFuncionario);
    }

    public FuncionarioDTO(boolean pOk, String pMensagem, List<Funcionario> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Funcionario getFuncionario()
    {
        return getObjeto();
    }

    public void setFuncionario(Funcionario pFuncionario)
    {
        setObjeto(pFuncionario);
    }
}
