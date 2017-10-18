package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.Fornecedor;

@XmlRootElement(name = "FornecedorDTO")
public class FornecedorDTO extends AbstractDTO<Fornecedor>
{
	
	/* Construtores da classe */
    public FornecedorDTO()
    {
        super();
    }

    public FornecedorDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public FornecedorDTO(boolean pOk, String pMensagem, Fornecedor pFornecedor)
    {
        super(pOk, pMensagem, pFornecedor);
    }

    public FornecedorDTO(boolean pOk, String pMensagem, List<Fornecedor> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Fornecedor getFornecedor()
    {
        return getObjeto();
    }

    public void setFornecedor(Fornecedor pFornecedor)
    {
        setObjeto(pFornecedor);
    }
	
}
