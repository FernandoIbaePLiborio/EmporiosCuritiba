package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.ProdutoDAO;
import com.emporios.dto.ProdutoDTO;
import com.emporios.model.Produto;

public class ProdutoController {
	// M�todo para criar uma categoria
	public static ProdutoDTO cadastrar(Produto pProduto) {
		if (pProduto == null)
			return new ProdutoDTO(false, "N�o � poss�vel inserir dados nulos");

		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		Produto tProduto = tDao.create(pProduto);

		if (tProduto == null)
			return new ProdutoDTO(false, "Problemas na grava��o de autentica��o");

		return new ProdutoDTO(true, "Produto gravado com sucesso", tProduto);
	}

	// M�todo para recuperar um usu�rio
	public static ProdutoDTO recuperar(int id) {
		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		Produto tProduto = tDao.recovery(id);

		if (tProduto == null)
			return new ProdutoDTO(false, "Produto n�o existe no cadastro");

		return new ProdutoDTO(true, "Leitura de Produto", tProduto);
	}

	// M�todo para atualizar uma categoria
	public static ProdutoDTO atualizar(Produto pProduto) {
		if (pProduto == null)
			return new ProdutoDTO(false, "Tentativa de atualiza��o sem sucesso!");

		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		Produto tProduto = tDao.update(pProduto);

		if (tProduto == null)
			return new ProdutoDTO(false, "Produto n�o existe no cadastro!");

		return new ProdutoDTO(true, "Produto atualizado com sucesso", tProduto);
	}

	// M�todo para deletar categorias
	public static ProdutoDTO remover(int id) {
		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		if (!tDao.delete(id))
			return new ProdutoDTO(false, "Autenticac�o n�o pode ser removida");

		return new ProdutoDTO(true, "Autenticac�o removida com sucesso!");
	}

	// M�todo para pesquisar todos as categorias
	public static ProdutoDTO pesquisar() {
		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		List<Produto> tLista = tDao.search();

		if (tLista.isEmpty())
			return new ProdutoDTO(false, "Lista vazia");

		return new ProdutoDTO(true, "Lista", tLista);
	}

	// M�todo para pesquisar por nome as categorias
	public static ProdutoDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();

		ProdutoDAO tDao = DaoFactory.getProdutoDAO();
		List<Produto> tLista = tDao.searchByNome(pNome);

		if (tLista.isEmpty())
			return new ProdutoDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new ProdutoDTO(true, "Produto", tLista);
	}
}
