package com.emporios.controller;

import java.util.ArrayList;
import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.Produto_FornecedorDAO;
import com.emporios.dto.Produto_FornecedorDTO;
import com.emporios.model.Produto_Fornecedor;

public class Produto_FornecedorController {
	// Método para criar um usuário
	public static Produto_FornecedorDTO cadastrar(Produto_Fornecedor pProduto_Fornecedor) {
		if (pProduto_Fornecedor == null)
			return new Produto_FornecedorDTO(false, "Tentativa de inserir um fornecedor nulo");

		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		Produto_Fornecedor tProduto_Fornecedor = tDao.create(pProduto_Fornecedor);
		if (tProduto_Fornecedor == null)
			return new Produto_FornecedorDTO(false, "Problemas na gravação do fornecedor");
		return new Produto_FornecedorDTO(true, "Produto gravado com sucesso", tProduto_Fornecedor);
	}

	// Método para recuperar um usuário
	public static Produto_FornecedorDTO recuperar(int id) {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		Produto_Fornecedor tProduto_Fornecedor = tDao.recovery(id);

		if (tProduto_Fornecedor == null)
			return new Produto_FornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new Produto_FornecedorDTO(true, "Produto_Fornecedor lido com sucesso", tProduto_Fornecedor);
	}

	// Método para atualizar um usuário
	public static Produto_FornecedorDTO atualizar(Produto_Fornecedor pProduto_Fornecedor) {
		if (pProduto_Fornecedor == null)
			return new Produto_FornecedorDTO(false, "Tentativa de atualizar um fornecedor nulo");

		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		Produto_Fornecedor tProduto_Fornecedor = tDao.update(pProduto_Fornecedor);

		if (tProduto_Fornecedor == null)
			return new Produto_FornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new Produto_FornecedorDTO(true, "Produto_Fornecedor regravado com sucesso", tProduto_Fornecedor);
	}

	// Método para deletar um usuário
	public static Produto_FornecedorDTO remover(int id) {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		if (!tDao.delete(id))
			return new Produto_FornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new Produto_FornecedorDTO(true, "Fornecedor removido com sucesso");
	}

	// Método para pesquisar todos os produtos
	public static Produto_FornecedorDTO pesquisar() {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.search();

		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Lista vazia");

		return new Produto_FornecedorDTO(true, "Lista geral de produtos cadastrados", tLista);
	}
	
	/**
	 *  // Método para pesquisar Relatório de Vendas conforme o dia da semana
	 * @return
	 */
	public static Produto_FornecedorDTO pesquisaVendaSemanal() {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.quantidadeVendaSemanal();
		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Lista vazia");

		return new Produto_FornecedorDTO(true, "Relatório de Venda Semanal", tLista);
	}
	
	/**
	 *  // Método para pesquisar Relatório de Produtos pelos respectivos fornecedores
	 * @return
	 */
	public static List<Produto_Fornecedor> listaProdutoPorFornecedor() {
		List<Produto_Fornecedor> list = new ArrayList<Produto_Fornecedor>();
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.produtoPorFornecedor();
		if (tLista.isEmpty())
			return null;
		list = tLista;
		return tLista;
	}
	/**
	 *  Método para recuperar um usuário
	 * @param pFornecedor
	 * @return
	 */
	public static Produto_FornecedorDTO pesquisarProdutos(int pFornecedor) {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.produtosFornecedor(pFornecedor);

		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Nenhum registro encontrado!'" + pFornecedor + "'");

		return new Produto_FornecedorDTO(true, "Lista de Produtos", tLista);
	}

	/**
	 *  // Método para pesquisar todos os produtos por categoria
	 * @param pProduto_Categoria
	 * @return
	 */
	public static Produto_FornecedorDTO pesquisarCategoria(String pProduto_Categoria) {
		if (pProduto_Categoria == null)
			return pesquisar();

		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.buscaPorCategoria(pProduto_Categoria);

		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Nenhum registro encontrado'" + pProduto_Categoria + "'");

		// Retornando a lista obtida
		return new Produto_FornecedorDTO(true, "Lista de Categorias", tLista);
	}

	/**
	 *  Método para pesquisar todos os produtos do fornecedor
	 * @param pFornecedor
	 * @return
	 */
	public static Produto_FornecedorDTO pesquisarPorFornecedor(String pFornecedor) {
		if (pFornecedor == null)
			return pesquisar();

		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.searchByProduto_Fornecedor(pFornecedor);

		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Nenhum produto encontrado '" + pFornecedor + "'");
		return new Produto_FornecedorDTO(true, "Produtos", tLista);
	}
	
	/**
	 *  Método para pesquisar todos os produtos do fornecedor
	 * @param pFornecedor
	 * @return
	 */
	public static Produto_FornecedorDTO produtoPorFornecedor() {
		Produto_FornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<Produto_Fornecedor> tLista = tDao.produtoPorFornecedor();
		if (tLista.isEmpty())
			return new Produto_FornecedorDTO(false, "Nenhum produto encontrado '");

		return new Produto_FornecedorDTO(true, "Produtos", tLista);
	}
}
