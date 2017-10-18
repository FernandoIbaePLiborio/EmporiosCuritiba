package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.FuncionarioDAO;
import com.emporios.dto.FuncionarioDTO;
import com.emporios.model.Funcionario;

public class FuncionarioController{
	// M�todo para criar um usu�rio
	 public static FuncionarioDTO cadastrar(Funcionario pFuncionario) {
		 if (pFuncionario == null)
	            return new FuncionarioDTO(false, "Tentativa de inserir um Funcionario nulo");
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        Funcionario tFuncionario = tDao.create(pFuncionario);
	        if (tFuncionario == null)
	            return new FuncionarioDTO(false, "Problemas na grava��o do Funcionario");
	        return new FuncionarioDTO(true, "Funcionario gravado com sucesso", tFuncionario);
	    }
	 
	 	// M�todo para recuperar um usu�rio
	    public static FuncionarioDTO recuperar(int id) {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        Funcionario tFuncionario = tDao.recovery(id);
	        if (tFuncionario == null)
	            return new FuncionarioDTO(false, "Funcionario n�o existe no cadastro");
	        
	        return new FuncionarioDTO(true, "Funcionario lido com sucesso", tFuncionario);
	    }

	    // M�todo para atualizar um usu�rio
	    public static FuncionarioDTO atualizar(Funcionario pFuncionario) {
	    	 if (pFuncionario == null)
	             return new FuncionarioDTO(false, "Tentativa de atualizar um Funcionario nulo");
	         FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	         Funcionario tFuncionario = tDao.update(pFuncionario);
	         if (tFuncionario == null)
	             return new FuncionarioDTO(false, "Funcionario n�o existe no cadastro");

	         return new FuncionarioDTO(true, "Funcionario regravado com sucesso", tFuncionario);
	    }

	    // M�todo para deletar um usu�rio
	    public static FuncionarioDTO remover(int id) {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        if (! tDao.delete(id))
	            return new FuncionarioDTO(false, "Funcionario n�o existe no cadastro");
	        return new FuncionarioDTO(true, "Funcionario removido com sucesso");
	    }

	    // M�todo para pesquisar todos os usu�rios
	    public static FuncionarioDTO pesquisar() {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        List<Funcionario> tLista = tDao.search();
	        if (tLista.isEmpty())
	            return new FuncionarioDTO(false, "Lista vazia");
	        return new FuncionarioDTO(true, "Lista de Funcionarios", tLista);
	    }

	    // M�todo para pesquisar por nome todos os usu�rios
	    public static FuncionarioDTO pesquisarPorFuncionario(String pFuncionario) {
	        if (pFuncionario == null)
	            return pesquisar();
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        List<Funcionario> tLista = tDao.searchByFuncionario(pFuncionario);
	        if (tLista.isEmpty())
	            return new FuncionarioDTO(false, "Nenhum registro encontrado com Companhia '" + pFuncionario + "'");
	        return new FuncionarioDTO(true, "Lista de Funcionarioes", tLista);
	    }

	    // M�todo para pesquisar verificar usuarios ativos.
	    public static FuncionarioDTO pesquisarPorAtivo(char pAtivo) {
	        if (pAtivo == '0')
	            return pesquisar();

	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        List<Funcionario> tLista = tDao.searchByAtivo(pAtivo);
	        if (tLista.isEmpty())
	            return new FuncionarioDTO(false, "Nenhum registro encontrado '" + pAtivo + "'");
	        return new FuncionarioDTO(true, "Lista de Funcionarios", tLista);
	    }
	}
