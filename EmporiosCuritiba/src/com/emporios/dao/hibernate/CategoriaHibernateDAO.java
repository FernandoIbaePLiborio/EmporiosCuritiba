package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.CategoriaDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Categoria;
import com.emporios.util.ExceptionUtil;

public class CategoriaHibernateDAO implements CategoriaDAO {

	@Override
	public Categoria create(Categoria pCategoria) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// salvando o objeto via hibernate
			tSessao.save(pCategoria);
			tSessao.flush();

			// retornando o objeto atualizado
			return pCategoria;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o");
		}

		return null;
	}

	// M�todo para recuperar um Categoria da base de dados (SELECT)

	@Override
	public Categoria recovery(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Categoria tCategoria = (Categoria) tSessao.get(Categoria.class, pMatricula);

			// Retornando o objeto lido
			return tCategoria;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o");
		}
		return null;
	}

	// M�todo para atualizar um Categoria na base de dados (UPDATE)

	@Override
	public Categoria update(Categoria pCategoria) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Ataulizando o objeto via hibernate
			tSessao.merge(pCategoria);
			tSessao.flush();

			// Retornando o objeto atualizado
			return pCategoria;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o");
		}
		return null;
	}

	// M�todo para deletar um Categoria na base de dados (DELETE)

	@Override
	public boolean delete(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			tSessao.delete(tSessao.get(Categoria.class, pMatricula));
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Categoria");
		}

		return false;
	}

	// M�todo para pesquisar todos os usu�rios da base de dados

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> search() {
		// Criando a tLista de Categoria vazia
		List<Categoria> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("FROM CATEGORIA");

			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Categoria");
		}

		// Retornando a lista de usu�rios
		return tLista;
	}

	// M�todo para pesquisar por nome todos os Categorias da base de dados

	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> searchByNome(String pNome) {
		// Acertando o crit�rio de pesquisa
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";

		// Criando a Lista vazia
		List<Categoria> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o crit�rio para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Categoria.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			// Recuperando a lista via hibernate
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista");
		}
		// Retornando a lista
		return tLista;
	}

}
