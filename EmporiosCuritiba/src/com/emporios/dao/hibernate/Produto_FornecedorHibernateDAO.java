package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.Produto_FornecedorDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Categoria;
import com.emporios.model.Produto_Fornecedor;
import com.emporios.util.ExceptionUtil;

public class Produto_FornecedorHibernateDAO implements Produto_FornecedorDAO {

	@Override
	public Produto_Fornecedor create(Produto_Fornecedor pProduto_Fornecedor) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.save(pProduto_Fornecedor);
			tSessao.flush();
			return pProduto_Fornecedor;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de criação do Produto_Fornecedor");
		}
		return null;
	}

	// Método para recuperar um autenticacao da base de dados (SELECT)
	@Override
	public Produto_Fornecedor recovery(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Produto_Fornecedor tProduto_Fornecedor = (Produto_Fornecedor) tSessao.get(Produto_Fornecedor.class, pMatricula);
			return tProduto_Fornecedor;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação do produto");
		}
		return null;
	}

	// Método para atualizar um autenticacao na base de dados (UPDATE)
	@Override
	public Produto_Fornecedor update(Produto_Fornecedor pProduto_Fornecedor) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.merge(pProduto_Fornecedor);
			tSessao.flush();
			return pProduto_Fornecedor;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do autenticacao");
		}
		return null;
	}

	// Método para deletar um autenticacao na base de dados (DELETE)
	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.delete(tSessao.get(Produto_Fornecedor.class, pMatricula));
			tSessao.flush();
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de atualização do autenticacao");
		}

		return false;
	}
	/**
	 * Método para pesquisar todos os produtos
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Produto_Fornecedor> search() {
		List<Produto_Fornecedor> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQuery = tSessao.createQuery("select p from PRODUTO_FORNECEDOR p order by p.preco_unitario");
			tLista = tQuery.list();

		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método para listar Produtos ");
		}
		return tLista;
	}
		/**
		 * Método retorna quantidade de Vendas de todas as Lojas por dia da Semana (Relatório). 
		 */
		@Override
		@SuppressWarnings("unchecked")
		public List<Produto_Fornecedor> quantidadeVendaSemanal() {
			List<Produto_Fornecedor> tLista = new ArrayList<>();
			try {
				SessionFactory tFactory = HibernateUtil.getSessionFactory();
				Session tSessao = tFactory.getCurrentSession();
				Query tQuery = tSessao.createQuery("select count(*) quantidade, fornec.companhia, TO_CHAR(p.dataEntrega,'DAY') "
						+ "from Fornecedor fornec, Pedido p, Funcionario fun where fornec.id = fun.fornecedor.id "
						+ "and fun.id = p.funcionario.id group by TO_CHAR(p.dataEntrega,'DAY'), fornec.companhia"); 
				return tQuery.list();
			} catch (HibernateException tExcept) {
				ExceptionUtil.mostrarErro(tExcept, "Erro no método para listar Produtos ");
			}
			return null;
		}



	@SuppressWarnings("unchecked")
	@Override
	public List<Produto_Fornecedor> produtosFornecedor(int pFornecedor) {
		// Acertando o critério de pesquisa
		String tProdutoFornecedor = "%" + pFornecedor + "%";

		// Criando a tLista vazia
		List<Produto_Fornecedor> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o critério para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Produto_Fornecedor.class)
					.add(Restrictions.like("Produto_Fornecedor", tProdutoFornecedor).ignoreCase());

			// Recuperando a lista via hibernate
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Produtos");
		}

		// Retornando a lista
		return tLista;

	}

	// Método para pesquisar por nome todos os produtos de uma categoria
	@SuppressWarnings("unchecked")
	public List<Produto_Fornecedor> buscaPorCategoria(String pCategoria) {

		// Acertando o critério de pesquisa
		String categoria = "%" + pCategoria + "%";
		CategoriaHibernateDAO metod = new CategoriaHibernateDAO();
		List<Categoria> categorias = metod.searchByNome(categoria);

		Categoria cat = new Categoria(); // passo o 1º elemento da lista para o
											// objeto
		cat = categorias.get(0);

		if (categorias != null) {
			for (Categoria categ : categorias) {
				if (categ.getNome().equals(cat.getNome())) {// comparação
					categoria = String.valueOf(categ.getId());
				}
			}
		}
		int pCategoriaProduto = Integer.parseInt(categoria);

		List<Produto_Fornecedor> tLista = new ArrayList<>();
		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Produto_Fornecedor.class).add(Restrictions.like("Produto_Fornecedor", pCategoriaProduto).ignoreCase());

			// return tSessao.createQuery("select * from Produto_Fornecedor pf
			// where pf.categorias.nome =
			// :categoriaNome").setParameter("categoriaNome", categoria).list();
			// Produto_Fornecedor tProduto_Fornecedor = (Produto_Fornecedor)
			// tSessao.get(Produto_Fornecedor.class, pMatricula);

			// Retornando o objeto lido
			// return tProduto_Fornecedor;*/

			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação de Categorias");
		}
		return tLista;

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Produto_Fornecedor> searchByProduto_Fornecedor(String pProduto) {
		// Acertando o critério de pesquisa
		String tProdutoPesquisa = "%" + pProduto + "%";

		// Criando a tLista vazia
		List<Produto_Fornecedor> tLista = new ArrayList<>();

		try {
			// Obtendo a sessão hibernate
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();

			// Criando o critério para pesquisa
			Criteria tCriterio = tSessao.createCriteria(Produto_Fornecedor.class)
					.add(Restrictions.like("Produto_Fornecedor", tProdutoPesquisa).ignoreCase());

			// Recuperando a lista via hibernate
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método de recuperação da lista de Produtos");
		}

		// Retornando a lista
		return tLista;
	}

	/**
	 * Método retorna Relatório de Produto por Fornecedor.
	 */
	@Override
	public List<Produto_Fornecedor> produtoPorFornecedor() {
		
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQueryT = tSessao.createQuery("SELECT pf FROM PRODUTO_FORNECEDOR pf "
					+ "INNER JOIN pf.produto p "
					+ "INNER JOIN pf.fornecedor f "
					+ "WHERE pf.produto.id = p.id AND pf.fornecedor.id = f.id order by p.nome, preco_unitario");
			return tQueryT.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no método para listar ");
		}
		return null;
	}

}
