package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.FuncionarioDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Funcionario;
import com.emporios.util.ExceptionUtil;

public class FuncionarioHibernateDAO implements FuncionarioDAO{

	 @Override
	    public Funcionario create(Funcionario pFuncionario)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // salvando o objeto via hibernate
	            tSessao.save(pFuncionario);
	            tSessao.flush();

	            // retornando o objeto atualizado
	            return pFuncionario;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o do Funcionario");
	        }

	        return null;
	    }

	    // M�todo para recuperar um autenticacao da base de dados (SELECT)

	    @Override
	    public Funcionario recovery(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Recuperando o objeto via hibernate
	            Funcionario tFuncionario = (Funcionario) tSessao.get(Funcionario.class, pMatricula);

	            // Retornando o objeto lido
	            return tFuncionario;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do autenticacao");
	        }
	        return null;
	    }

	    @Override
	    public Funcionario update(Funcionario pFuncionario)
	    {
	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Ataulizando o objeto via hibernate
	            tSessao.merge(pFuncionario);
	            tSessao.flush();

	            // Retornando o objeto atualizado
	            return pFuncionario;
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
	            tSessao.delete(tSessao.get(Funcionario.class, pMatricula));
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
	    public List<Funcionario> search()
	    {
	        // Criando a tLista de autenticacao vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM FUNCIONARIO");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de funcionarios");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    // M�todo para pesquisar por nome todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Funcionario> searchByFuncionario(String pFuncionario)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tFuncionarioPesquisa = "%" + pFuncionario + "%";

	        // Criando a tLista de autenticacaos vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Funcionario.class)
	                                          .add(Restrictions.like("Funcionario", tFuncionarioPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Funcionarios");
	        }

	        // Retornando a lista
	        return tLista;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Funcionario> searchByAtivo(char pAtivo)
	    {
	        // Acertando o crit�rio de pesquisa
	        String tAtivoPesquisa = "%" + pAtivo + "%";

	        // Criando a tLista vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sess�o hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o crit�rio para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Funcionario.class)
	                                          .add(Restrictions.like("Ativo", tAtivoPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Funcionario");
	        }

	        // Retornando a lista
	        return tLista;
	    }

}
