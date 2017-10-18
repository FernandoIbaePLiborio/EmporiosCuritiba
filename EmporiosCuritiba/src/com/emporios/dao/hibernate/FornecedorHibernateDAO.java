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
	            // Obtendo a sessão hibernate
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
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Fornecedor");
	        }

	        return null;
	    }

	    // Método para recuperar um autenticacao da base de dados (SELECT)

	    @Override
	    public Fornecedor recovery(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Recuperando o objeto via hibernate
	            Fornecedor tFornecedor = (Fornecedor) tSessao.get(Fornecedor.class, pMatricula);

	            // Retornando o objeto lido
	            return tFornecedor;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do autenticacao");
	        }
	        return null;
	    }

	    // Método para atualizar um autenticacao na base de dados (UPDATE)

	    @Override
	    public Fornecedor update(Fornecedor pFornecedor)
	    {
	        try
	        {
	            // Obtendo a sessão hibernate
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
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do autenticacao");
	        }
	        return null;
	    }

	    // Método para deletar um autenticacao na base de dados (DELETE)
	
	    @Override
	    public boolean delete(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sessão hibernate
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
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do autenticacao");
	        }

	        return false;
	    }

	    // Método para pesquisar todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> search()
	    {
	        // Criando a tLista de autenticacao vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM FORNECEDOR");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de autenticacao");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    // Método para pesquisar por nome todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> searchByCompanhia(String pCompanhia)
	    {
	        // Acertando o critério de pesquisa
	        String tCompanhiaPesquisa = "%" + pCompanhia + "%";

	        // Criando a tLista de autenticacaos vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o critério para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Fornecedor.class)
	                                          .add(Restrictions.like("Companhia", tCompanhiaPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Companhia");
	        }

	        // Retornando a lista 
	        return tLista;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Fornecedor> searchByCnpj(String pCnpj)
	    {
	        // Acertando o critério de pesquisa
	        String tCnpjPesquisa = "%" + pCnpj + "%";

	        // Criando a tLista vazia
	        List<Fornecedor> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o critério para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Fornecedor.class)
	                                          .add(Restrictions.like("Cnpj", tCnpjPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Cnpj");
	        }

	        // Retornando a lista 
	        return tLista;
	    }

}
