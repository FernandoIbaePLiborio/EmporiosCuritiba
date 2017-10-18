
package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.FornecedorDAO;
import com.emporios.dto.FornecedorDTO;
import com.emporios.model.Fornecedor;

public class FornecedorController {

	// M�todo para criar um usu�rio
	public static FornecedorDTO cadastrar(Fornecedor pFornecedor) {
		if (pFornecedor == null)
			return new FornecedorDTO(false, "Tentativa de inserir um fornecedor nulo");
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.create(pFornecedor);
		if (tFornecedor == null)
			return new FornecedorDTO(false, "Problemas na grava��o do fornecedor");

		return new FornecedorDTO(true, "Fornecedor gravado com sucesso", tFornecedor);
	}

	// M�todo para recuperar um usu�rio
	public static FornecedorDTO recuperar(int id) {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.recovery(id);
		if (tFornecedor == null)
			return new FornecedorDTO(false, "Fornecedor n�o existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor lido com sucesso", tFornecedor);
	}

	// M�todo para atualizar um usu�rio
	public static FornecedorDTO atualizar(Fornecedor pFornecedor) {
		if (pFornecedor == null)
			return new FornecedorDTO(false, "Tentativa de atualizar um fornecedor nulo");

		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		Fornecedor tFornecedor = tDao.update(pFornecedor);

		if (tFornecedor == null)
			return new FornecedorDTO(false, "Fornecedor n�o existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor regravado com sucesso", tFornecedor);
	}

	// M�todo para deletar um usu�rio
	public static FornecedorDTO remover(int id) {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		if (!tDao.delete(id))
			return new FornecedorDTO(false, "Fornecedor n�o existe no cadastro");

		return new FornecedorDTO(true, "Fornecedor removido com sucesso");
	}

	// M�todo para pesquisar todos os usu�rios
	public static FornecedorDTO pesquisar() {
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		List<Fornecedor> tLista = tDao.search();
		if (tLista.isEmpty())
			return new FornecedorDTO(false, "Lista vazia");

		return new FornecedorDTO(true, "Lista de fornecedores", tLista);
	}

	// M�todo para pesquisar por nome todos os usu�rios
	public static FornecedorDTO pesquisarPorCompanhia(String pCompanhia) {
		if (pCompanhia == null)
			return pesquisar();
		FornecedorDAO tDao = DaoFactory.getFornecedorDAO();
		List<Fornecedor> tLista = tDao.searchByCompanhia(pCompanhia);
		if (tLista.isEmpty())
			return new FornecedorDTO(false, "Nenhum registro encontrado com Companhia '" + pCompanhia + "'");
		return new FornecedorDTO(true, "Lista de fornecedores", tLista);
	}

	// M�todo para pesquisar por email todos os usu�rios
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
