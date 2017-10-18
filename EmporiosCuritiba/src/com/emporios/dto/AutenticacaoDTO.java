package com.emporios.dto;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Autenticacao;

@XmlRootElement(name = "AutenticacaoDTO")
public class AutenticacaoDTO extends AbstractDTO<Autenticacao>
{
	
	/* Construtores da classe */
    public AutenticacaoDTO()
    {
        super();
    }

    public AutenticacaoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public AutenticacaoDTO(boolean pOk, String pMensagem, Autenticacao pAutenticacao)
    {
        super(pOk, pMensagem, pAutenticacao);
    }

    public AutenticacaoDTO(boolean pOk, String pMensagem, List<Autenticacao> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Autenticacao getAutenticacao()
    {
        return getObjeto();
    }

    public void setAutenticacao(Autenticacao pAutenticacao)
    {
        setObjeto(pAutenticacao);
    }
	
}
