package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.ProdutoFornecedor;

@XmlRootElement(name = "Produto_FornecedorDTO")
public class ProdutoFornecedorDTO extends AbstractDTO<ProdutoFornecedor> {
	/* Construtores da classe */
    public ProdutoFornecedorDTO()
    {
        super();
    }

    public ProdutoFornecedorDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoFornecedorDTO(boolean pOk, String pMensagem, ProdutoFornecedor pProduto_Fornecedor)
    {
        super(pOk, pMensagem, pProduto_Fornecedor);
    }

    public ProdutoFornecedorDTO(boolean pOk, String pMensagem, List<ProdutoFornecedor> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public ProdutoFornecedor getProduto_Fornecedor()
    {
        return getObjeto();
    }

    public void setProduto_Fornecedor(ProdutoFornecedor pProduto_Fornecedor)
    {
        setObjeto(pProduto_Fornecedor);
    }
}
