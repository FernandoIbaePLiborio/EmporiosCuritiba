
package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.FornecedorDAO;
import com.emporios.dto.FornecedorDTO;
import com.emporios.model.Fornecedor;

public class FornecedorController {

	// Método para criar um usuário
	public static FornecedorDTO cadastrar(Fornecedor pFornecedor) {
		if (pFornecedor == null)
			return new FornecedorDTO(false, "Tentativa de inserir um fornecedor nulo");
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.create(pFornecedor);
		if (tFornecedor == null)
			return new FornecedorDTO(false, "Problemas na gravação do fornecedor");

		return new FornecedorDTO(true, "Fornecedor gravado com sucesso", tFornecedor);
	}

	// Método para recuperar um usuário
	public static FornecedorDTO recuperar(int id) {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.recovery(id);
		if (tFornecedor == null)
			return new FornecedorDTO(false, "Fornecedor não existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor lido com sucesso", tFornecedor);
	}

	// Método para atualizar um usuário
	public static FornecedorDTO atualizar(Fornecedor pFornecedor) {
		if (pFornecedor == null)
			return new FornecedorDTO(false, "Tentativa de atualizar um fornecedor nulo");

		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.update(pFornecedor);

		if (tFornecedor == null)
			return new FornecedorDTO(false, "Fornecedor não existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor regravado com sucesso", tFornecedor);
	}

	// Método para deletar um usuário
	public static FornecedorDTO remover(int id) {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		if (!tDao.delete(id))
			return new FornecedorDTO(false, "Fornecedor não existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor removido com sucesso");
	}

	// Método para pesquisar todos os usuários
	public static FornecedorDTO pesquisar() {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		List<Fornecedor> tLista = tDao.search();
		if (tLista.isEmpty())
			return new FornecedorDTO(false, "Lista vazia");

		return new FornecedorDTO(true, "Lista de fornecedores", tLista);
	}

	// Método para pesquisar por nome todos os usuários
	public static FornecedorDTO pesquisarPorCompanhia(String pCompanhia) {
		if (pCompanhia == null)
			return pesquisar();
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		List<Fornecedor> tLista = tDao.searchByCompanhia(pCompanhia);
		if (tLista.isEmpty())
			return new FornecedorDTO(false, "Nenhum registro encontrado com Companhia '" + pCompanhia + "'");
		return new FornecedorDTO(true, "Lista de fornecedores", tLista);
	}

	// Método para pesquisar por email todos os usuários
	public static FornecedorDTO pesquisarPorCnpj(String pCnpj) {
		if (pCnpj == null)
			return pesquisar();
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		List<Fornecedor> tLista = tDao.searchByCnpj(pCnpj);
		if (tLista.isEmpty())
			return new FornecedorDTO(false, "Nenhum registro encontrado com Cnpj '" + pCnpj + "'");

		return new FornecedorDTO(true, "Lista de fornecedores", tLista);
	}
}
