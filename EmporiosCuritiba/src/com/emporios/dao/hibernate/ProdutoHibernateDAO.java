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
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// salvando o objeto via hibernate
			tSessao.save(pProduto);
			tSessao.flush();

			// retornando o objeto atualizado
			return pProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o");
		}

		return null;
	}

	// M�todo para recuperar um Produto da base de dados (SELECT)

	@Override
	public Produto recovery(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Recuperando o objeto via hibernate
			Produto tProduto = (Produto) tSessao.get(Produto.class, pMatricula);

			// Retornando o objeto lido
			return tProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o");
		}
		return null;
	}

	// M�todo para atualizar um Produto na base de dados (UPDATE)
	@Override
	public Produto update(Produto pProduto) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Ataulizando o objeto via hibernate
			tSessao.merge(pProduto);
			tSessao.flush();

			// Retornando o objeto atualizado
			return pProduto;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o");
		}
		return null;
	}

	// M�todo para deletar um Produto na base de dados (DELETE)
	@Override
	public boolean delete(int pMatricula) {
		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Removendo o objeto via hibernate
			tSessao.delete(tSessao.get(Produto.class, pMatricula));
			tSessao.flush();

			// Retornando indicativo de sucesso
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do Produto");
		}

		return false;
	}

	// M�todo para pesquisar todos os usu�rios da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> search() {
		// Criando a tLista de Produto vazia
		List<Produto> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o objeto para pesquisa
			Query tQuery = tSessao.createQuery("from PRODUTO p order by p.nome");

			// Recuperando a lista via hibernate
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de Produto");
		}

		// Retornando a lista de usu�rios
		return tLista;
	}

	// M�todo para pesquisar por nome todos os Produtos da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto> searchByNome(String pNome) {
		// Acertando o crit�rio de pesquisa
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";

		// Criando a Lista vazia
		List<Produto> tLista = new ArrayList<>();

		try {
			// Obtendo a sess�o hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o crit�rio para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Produto.class)
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
