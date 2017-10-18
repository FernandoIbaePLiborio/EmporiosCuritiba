package com.emporios.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.model.Categoria;

@XmlRootElement(name = "CategoriaDTO")
public class CategoriaDTO extends AbstractDTO<Categoria>
{
	/* Construtores da classe */
    public CategoriaDTO()
    {
        super();
    }

    public CategoriaDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public CategoriaDTO(boolean pOk, String pMensagem, Categoria pCategoria)
    {
        super(pOk, pMensagem, pCategoria);
    }

    public CategoriaDTO(boolean pOk, String pMensagem, List<Categoria> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Categoria getCategoria()
    {
        return getObjeto();
    }

    public void setCategoria(Categoria pCategoria)
    {
        setObjeto(pCategoria);
    }

}
