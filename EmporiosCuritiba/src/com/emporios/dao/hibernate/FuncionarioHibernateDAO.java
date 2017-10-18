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
	            // Obtendo a sessão hibernate
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
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Funcionario");
	        }

	        return null;
	    }

	    // Método para recuperar um autenticacao da base de dados (SELECT)

	    @Override
	    public Funcionario recovery(int pMatricula)
	    {
	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Recuperando o objeto via hibernate
	            Funcionario tFuncionario = (Funcionario) tSessao.get(Funcionario.class, pMatricula);

	            // Retornando o objeto lido
	            return tFuncionario;
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do autenticacao");
	        }
	        return null;
	    }

	    @Override
	    public Funcionario update(Funcionario pFuncionario)
	    {
	        try
	        {
	            // Obtendo a sessão hibernate
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
	            tSessao.delete(tSessao.get(Funcionario.class, pMatricula));
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
	    public List<Funcionario> search()
	    {
	        // Criando a tLista de autenticacao vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o objeto para pesquisa
	            Query tQuery = tSessao.createQuery("FROM FUNCIONARIO");

	            // Recuperando a lista via hibernate
	            tLista = tQuery.list();

	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de funcionarios");
	        }

	        // Retornando a lista de autenticacaos
	        return tLista;
	    }

	    // Método para pesquisar por nome todos os autenticacaos da base de dados

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Funcionario> searchByFuncionario(String pFuncionario)
	    {
	        // Acertando o critério de pesquisa
	        String tFuncionarioPesquisa = "%" + pFuncionario + "%";

	        // Criando a tLista de autenticacaos vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o critério para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Funcionario.class)
	                                          .add(Restrictions.like("Funcionario", tFuncionarioPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Funcionarios");
	        }

	        // Retornando a lista
	        return tLista;
	    }

	    @Override
	    @SuppressWarnings("unchecked")
	    public List<Funcionario> searchByAtivo(char pAtivo)
	    {
	        // Acertando o critério de pesquisa
	        String tAtivoPesquisa = "%" + pAtivo + "%";

	        // Criando a tLista vazia
	        List<Funcionario> tLista = new ArrayList<>();

	        try
	        {
	            // Obtendo a sessão hibernate
	            SessionFactory tFactory = HibernateUtil.getSessionFactory();
	            Session tSessao = tFactory.getCurrentSession();

	            // Criando o critério para pesquisa
	            Criteria tCriterio = tSessao.createCriteria(Funcionario.class)
	                                          .add(Restrictions.like("Ativo", tAtivoPesquisa).ignoreCase());

	            // Recuperando a lista via hibernate
	            tLista = tCriterio.list();
	        }
	        catch (HibernateException tExcept)
	        {
	            ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Funcionario");
	        }

	        // Retornando a lista
	        return tLista;
	    }

}
