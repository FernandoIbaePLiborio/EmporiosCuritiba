package com.emporios.controller;

import java.util.ArrayList;
import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.ProdutoFornecedorDAO;
import com.emporios.dto.ProdutoFornecedorDTO;
import com.emporios.model.ProdutoFornecedor;

public class ProdutoFornecedorController {
	// Método para criar um usuário
	public static ProdutoFornecedorDTO cadastrar(ProdutoFornecedor pProduto_Fornecedor) {
		if (pProduto_Fornecedor == null)
			return new ProdutoFornecedorDTO(false, "Tentativa de inserir um fornecedor nulo");

		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		ProdutoFornecedor tProduto_Fornecedor = tDao.create(pProduto_Fornecedor);
		if (tProduto_Fornecedor == null)
			return new ProdutoFornecedorDTO(false, "Problemas na gravação do fornecedor");
		return new ProdutoFornecedorDTO(true, "Produto gravado com sucesso", tProduto_Fornecedor);
	}

	// Método para recuperar um usuário
	public static ProdutoFornecedorDTO recuperar(int id) {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		ProdutoFornecedor tProduto_Fornecedor = tDao.recovery(id);

		if (tProduto_Fornecedor == null)
			return new ProdutoFornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new ProdutoFornecedorDTO(true, "Produto_Fornecedor lido com sucesso", tProduto_Fornecedor);
	}

	// Método para atualizar um usuário
	public static ProdutoFornecedorDTO atualizar(ProdutoFornecedor pProduto_Fornecedor) {
		if (pProduto_Fornecedor == null)
			return new ProdutoFornecedorDTO(false, "Tentativa de atualizar um fornecedor nulo");

		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		ProdutoFornecedor tProduto_Fornecedor = tDao.update(pProduto_Fornecedor);

		if (tProduto_Fornecedor == null)
			return new ProdutoFornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new ProdutoFornecedorDTO(true, "Produto_Fornecedor regravado com sucesso", tProduto_Fornecedor);
	}

	// Método para deletar um usuário
	public static ProdutoFornecedorDTO remover(int id) {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		if (!tDao.delete(id))
			return new ProdutoFornecedorDTO(false, "Produto_Fornecedor não existe no cadastro");

		return new ProdutoFornecedorDTO(true, "Fornecedor removido com sucesso");
	}

	// Método para pesquisar todos os produtos
	public static ProdutoFornecedorDTO pesquisar() {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.search();

		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Lista vazia");

		return new ProdutoFornecedorDTO(true, "Lista geral de produtos cadastrados", tLista);
	}
	
	/**
	 *  // Método para pesquisar Relatório de Vendas conforme o dia da semana
	 * @return
	 */
	public static ProdutoFornecedorDTO pesquisaVendaSemanal() {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.quantidadeVendaSemanal();
		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Lista vazia");

		return new ProdutoFornecedorDTO(true, "Relatório de Venda Semanal", tLista);
	}
	
	/**
	 *  // Método para pesquisar Relatório de Produtos pelos respectivos fornecedores
	 * @return
	 */
	public static List<ProdutoFornecedor> listaProdutoPorFornecedor() {
		List<ProdutoFornecedor> list = new ArrayList<ProdutoFornecedor>();
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.produtoPorFornecedor();
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
	public static ProdutoFornecedorDTO pesquisarProdutos(int pFornecedor) {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.produtosFornecedor(pFornecedor);

		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Nenhum registro encontrado!'" + pFornecedor + "'");

		return new ProdutoFornecedorDTO(true, "Lista de Produtos", tLista);
	}

	/**
	 *  // Método para pesquisar todos os produtos por categoria
	 * @param pProduto_Categoria
	 * @return
	 */
	public static ProdutoFornecedorDTO pesquisarCategoria(String pProduto_Categoria) {
		if (pProduto_Categoria == null)
			return pesquisar();

		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.buscaPorCategoria(pProduto_Categoria);

		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Nenhum registro encontrado'" + pProduto_Categoria + "'");

		// Retornando a lista obtida
		return new ProdutoFornecedorDTO(true, "Lista de Categorias", tLista);
	}

	/**
	 *  Método para pesquisar todos os produtos do fornecedor
	 * @param pFornecedor
	 * @return
	 */
	public static ProdutoFornecedorDTO pesquisarPorFornecedor(String pFornecedor) {
		if (pFornecedor == null)
			return pesquisar();

		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.searchByProduto_Fornecedor(pFornecedor);

		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Nenhum produto encontrado '" + pFornecedor + "'");
		return new ProdutoFornecedorDTO(true, "Produtos", tLista);
	}
	
	/**
	 *  Método para pesquisar todos os produtos do fornecedor
	 * @param pFornecedor
	 * @return
	 */
	public static ProdutoFornecedorDTO produtoPorFornecedor() {
		ProdutoFornecedorDAO tDao = DaoFactory.getProduto_FornecedorDAO();
		List<ProdutoFornecedor> tLista = tDao.produtoPorFornecedor();
		if (tLista.isEmpty())
			return new ProdutoFornecedorDTO(false, "Nenhum produto encontrado '");

		return new ProdutoFornecedorDTO(true, "Produtos", tLista);
	}
}
