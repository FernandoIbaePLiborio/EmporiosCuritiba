package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.EnderecoDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Endereco;
import com.emporios.util.ExceptionUtil;

public class EnderecoHibernateDAO implements EnderecoDAO{
		
	 @Override
	    public Endereco create(Endereco pEndereco)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // salvando o objeto via hibernate
	            tSessao.save(pEndereco);
	            tSessao.flush();

	            // retornando o objeto atualizado
	            return pEndereco;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do Endereco");
	        }

	        return null;
	    }

	    // M�todo para recuperar um autenticacao da base de dados (SELECT)

	    @Override
	    public Endereco recovery(int pId)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Recuperando o objeto via hibernate
	            Endereco tEndereco = (Endereco) tSessao.get(Endereco.class, pId);

	            // Retornando o objeto lido
	            return tEndereco;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do Endereco");
	        }
	        return null;
	    }

	    // M�todo para atualizar um autenticacao na base de dados (UPDATE)

	    @Override
	    public Endereco update(Endereco pEndereco)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Ataulizando o objeto via hibernate
	            tSessao.merge(pEndereco);
	            tSessao.flush();

	            // Retornando o objeto atualizado
	            return pEndereco;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Endereco");
	        }
	        return null;
	    }

	    // M�todo para deletar um autenticacao na base de dados (DELETE)
	
	    @Override
	    public boolean delete(int pId)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Removendo o objeto via hibernate
	            tSessao.delete(tSessao.get(Endereco.class, pId));
	            tSessao.flush();

	            // Retornando indicativo de sucesso
	            return true;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Endereco");
	        }

	        return false;
	    }

	    // M�todo para pesquisar todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Endereco> search()
	    {
	        // Criando a tLista de autenticacao vazia
	        List<Endereco> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM ENDERECO");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Endereco");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    // M�todo para pesquisar por nome todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Endereco> searchByRua(String pRua)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tRuaPesquisa = "%" + pRua + "%";

	        // Criando a tLista de autenticacaos vazia
	        List<Endereco> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Endereco.class).add(Restrictions.like("Rua", tRuaPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Endereco por rua");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Endereco> searchByCep(String pCep)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tCepPesquisa = "%" + pCep + "%";

	        // Criando a tLista de autenticacao vazia
	        List<Endereco> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Endereco.class)
	                                          .add(Restrictions.like("cep", tCepPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Cnpj");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }


}
