package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.CategoriaDAO;
import com.emporios.daointerface.DaoFactory;
import com.emporios.dto.CategoriaDTO;
import com.emporios.model.Categoria;

public class CategoriaController {
	// Método para criar uma categoria
	public static CategoriaDTO cadastrar(Categoria pCategoria) {
		if (pCategoria == null)
			return new CategoriaDTO(false, "Não é possível inserir dados nulos");

		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.create(pCategoria);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Problemas na gravação de autenticação");

		return new CategoriaDTO(true, "Autenticacão gravada com sucesso", tCategoria);
	}

	// Método para recuperar um usuário
	public static CategoriaDTO recuperar(int id) {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.recovery(id);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Categoria não existe no cadastro");

		return new CategoriaDTO(true, "Leitura de Categoria", tCategoria);
	}

	// Método para atualizar uma categoria
	public static CategoriaDTO atualizar(Categoria pCategoria) {
		if (pCategoria == null)
			return new CategoriaDTO(false, "Tentativa de atualização sem sucesso!");

		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		Categoria tCategoria = tDao.update(pCategoria);

		if (tCategoria == null)
			return new CategoriaDTO(false, "Categoria não existe no cadastro!");

		return new CategoriaDTO(true, "Autenticacão regravada com sucesso", tCategoria);
	}

	// Método para deletar categorias
	public static CategoriaDTO remover(int id) {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		if (!tDao.delete(id))
			return new CategoriaDTO(false, "Autenticacão não pode ser removida");

		return new CategoriaDTO(true, "Autenticacão removida com sucesso!");
	}

	// Método para pesquisar todos as categorias
	public static CategoriaDTO pesquisar() {
		CategoriaDAO tDao = DaoFactory.getCategoriaDAO();
		List<Categoria> tLista = tDao.search();

		if (tLista.isEmpty())
			return new CategoriaDTO(false, "Lista vazia");

		return new CategoriaDTO(true, "Lista", tLista);
	}

	// Método para pesquisar por nome as categorias
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
