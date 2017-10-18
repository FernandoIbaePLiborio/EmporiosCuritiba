package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.Produto_Fornecedor;

@XmlRootElement(name = "Produto_FornecedorDTO")
public class Produto_FornecedorDTO extends AbstractDTO<Produto_Fornecedor> {
	/* Construtores da classe */
    public Produto_FornecedorDTO()
    {
        super();
    }

    public Produto_FornecedorDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public Produto_FornecedorDTO(boolean pOk, String pMensagem, Produto_Fornecedor pProduto_Fornecedor)
    {
        super(pOk, pMensagem, pProduto_Fornecedor);
    }

    public Produto_FornecedorDTO(boolean pOk, String pMensagem, List<Produto_Fornecedor> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Produto_Fornecedor getProduto_Fornecedor()
    {
        return getObjeto();
    }

    public void setProduto_Fornecedor(Produto_Fornecedor pProduto_Fornecedor)
    {
        setObjeto(pProduto_Fornecedor);
    }
}
