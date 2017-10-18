package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.Produto;

@XmlRootElement(name = "ProdutoDTO")
public class ProdutoDTO extends AbstractDTO<Produto>
{
	/* Construtores da classe */
    public ProdutoDTO()
    {
        super();
    }

    public ProdutoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, Produto pProduto)
    {
        super(pOk, pMensagem, pProduto);
    }

    public ProdutoDTO(boolean pOk, String pMensagem, List<Produto> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Produto getProduto()
    {
        return getObjeto();
    }

    public void setProduto(Produto pProduto)
    {
        setObjeto(pProduto);
    }

}
