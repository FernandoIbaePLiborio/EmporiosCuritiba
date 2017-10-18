package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.CategoriaDAO;
import com.emporios.daointerface.DaoFactory;
import com.emporios.dto.CategoriaDTO;
import com.emporios.model.Categoria;

public class CategoriaController {
	// M�todo para criar uma categoria
	public static CategoriaDTO cadastrar(Categoria pCategoria) {
		if (pCategoria == null)
			return new CategoriaDTO(false, "N�o � poss�vel inserir dados nulos");

		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.create(pCategoria);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Problemas na grava��o de autentica��o");

		return new CategoriaDTO(true, "Autenticac�o gravada com sucesso", tCategoria);
	}

	// M�todo para recuperar um usu�rio
	public static CategoriaDTO recuperar(int id) {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.recovery(id);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Categoria n�o existe no cadastro");

		return new CategoriaDTO(true, "Leitura de Categoria", tCategoria);
	}

	// M�todo para atualizar uma categoria
	public static CategoriaDTO atualizar(Categoria pCategoria) {
		if (pCategoria == null)
			return new CategoriaDTO(false, "Tentativa de atualiza��o sem sucesso!");

		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.update(pCategoria);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Categoria n�o existe no cadastro!");

		return new CategoriaDTO(true, "Autenticac�o regravada com sucesso", tCategoria);
	}

	// M�todo para deletar categorias
	public static CategoriaDTO remover(int id) {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		if (!tDao.delete(id))
			return new CategoriaDTO(false, "Autenticac�o n�o pode ser removida");

		return new CategoriaDTO(true, "Autenticac�o removida com sucesso!");
	}

	// M�todo para pesquisar todos as categorias
	public static CategoriaDTO pesquisar() {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		List<Categoria> tLista = tDao.search();

		if (tLista.isEmpty())
			return new CategoriaDTO(false, "Lista vazia");

		return new CategoriaDTO(true, "Lista", tLista);
	}

	// M�todo para pesquisar por nome as categorias
	public static CategoriaDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();

		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		List<Categoria> tLista = tDao.searchByNome(pNome);

		if (tLista.isEmpty())
			return new CategoriaDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new CategoriaDTO(true, "Categoria", tLista);
	}
}
