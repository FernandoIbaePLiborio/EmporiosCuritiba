package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.ProdutoDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Produto;
import com.emporios.util.ExceptionUtil;


public class ProdutoHibernateDAO implements ProdutoDAO {

	@Override
	public Produto create(Produto pProduto) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// salvando o objeto via hibernate
			tSessao.save(pProduto);
			tSessao.flush();

			// retornando o objeto atualizado
			return pProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação");
		}

		return null;
	}

	// Método para recuperar um Produto da base de dados (SELECT)

	@Override
	public Produto recovery(int pMatricula) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Produto tProduto = (Produto) tSessao.get(Produto.class, pMatricula);

			// Retornando o objeto lido
			return tProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação");
		}
		return null;
	}

	// Método para atualizar um Produto na base de dados (UPDATE)
	@Override
	public Produto update(Produto pProduto) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Ataulizando o objeto via hibernate
			tSessao.merge(pProduto);
			tSessao.flush();

			// Retornando o objeto atualizado
			return pProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização");
		}
		return null;
	}

	// Método para deletar um Produto na base de dados (DELETE)
	@Override
	public boolean delete(int pMatricula) {
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			tSessao.delete(tSessao.get(Produto.class, pMatricula));
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do Produto");
		}

		return false;
	}

	// Método para pesquisar todos os usuários da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> search() {
		// Criando a tLista de Produto vazia
		List<Produto> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("from PRODUTO p order by p.nome");

			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Produto");
		}

		// Retornando a lista de usuários
		return tLista;
	}

	// Método para pesquisar por nome todos os Produtos da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> searchByNome(String pNome) {
		// Acertando o critério de pesquisa
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";

		// Criando a Lista vazia
		List<Produto> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o critério para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Produto.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());

			// Recuperando a lista via hibernate
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista");
		}
		// Retornando a lista
		return tLista;
	}

}
