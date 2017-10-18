package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.FornecedorDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Fornecedor;
import com.emporios.util.ExceptionUtil;

public class FornecedorHibernateDAO implements FornecedorDAO{
	
	 @Override
	    public Fornecedor create(Fornecedor pFornecedor)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // salvando o objeto via hibernate
	            tSessao.save(pFornecedor);
	            tSessao.flush();

	            // retornando o objeto atualizado
	            return pFornecedor;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do Fornecedor");
	        }

	        return null;
	    }

	    // M�todo para recuperar um autenticacao da base de dados (SELECT)

	    @Override
	    public Fornecedor recovery(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Recuperando o objeto via hibernate
	            Fornecedor tFornecedor = (Fornecedor) tSessao.get(Fornecedor.class, pMatricula);

	            // Retornando o objeto lido
	            return tFornecedor;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do autenticacao");
	        }
	        return null;
	    }

	    // M�todo para atualizar um autenticacao na base de dados (UPDATE)

	    @Override
	    public Fornecedor update(Fornecedor pFornecedor)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Ataulizando o objeto via hibernate
	            tSessao.merge(pFornecedor);
	            tSessao.flush();

	            // Retornando o objeto atualizado
	            return pFornecedor;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do autenticacao");
	        }
	        return null;
	    }

	    // M�todo para deletar um autenticacao na base de dados (DELETE)
	
	    @Override
	    public boolean delete(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Removendo o objeto via hibernate
	            tSessao.delete(tSessao.get(Fornecedor.class, pMatricula));
	            tSessao.flush();

	            // Retornando indicativo de sucesso
	            return true;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do autenticacao");
	        }

	        return false;
	    }

	    // M�todo para pesquisar todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> search()
	    {
	        // Criando a tLista de autenticacao vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM FORNECEDOR");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de autenticacao");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    // M�todo para pesquisar por nome todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> searchByCompanhia(String pCompanhia)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tCompanhiaPesquisa = "%" + pCompanhia + "%";

	        // Criando a tLista de autenticacaos vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Fornecedor.class)
	                                          .add(Restrictions.like("Companhia", tCompanhiaPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Companhia");
	        }

	        // Retornando a lista 
	        return tLista;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> searchByCnpj(String pCnpj)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tCnpjPesquisa = "%" + pCnpj + "%";

	        // Criando a tLista vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Fornecedor.class)
	                                          .add(Restrictions.like("Cnpj", tCnpjPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Cnpj");
	        }

	        // Retornando a lista 
	        return tLista;
	    }

}
