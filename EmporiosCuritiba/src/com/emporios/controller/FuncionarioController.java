package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.FuncionarioDAO;
import com.emporios.dto.FuncionarioDTO;
import com.emporios.model.Funcionario;

public class FuncionarioController{
	// Método para criar um usuário
	 public static FuncionarioDTO cadastrar(Funcionario pFuncionario) {
		 if (pFuncionario == null)
	            return new FuncionarioDTO(false, "Tentativa de inserir um Funcionario nulo");
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        Funcionario tFuncionario = tDao.create(pFuncionario);
	        if (tFuncionario == null)
	            return new FuncionarioDTO(false, "Problemas na gravação do Funcionario");
	        return new FuncionarioDTO(true, "Funcionario gravado com sucesso", tFuncionario);
	    }
	 
	 	// Método para recuperar um usuário
	    public static FuncionarioDTO recuperar(int id) {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        Funcionario tFuncionario = tDao.recovery(id);
	        if (tFuncionario == null)
	            return new FuncionarioDTO(false, "Funcionario não existe no cadastro");
	        
	        return new FuncionarioDTO(true, "Funcionario lido com sucesso", tFuncionario);
	    }

	    // Método para atualizar um usuário
	    public static FuncionarioDTO atualizar(Funcionario pFuncionario) {
	    	 if (pFuncionario == null)
	             return new FuncionarioDTO(false, "Tentativa de atualizar um Funcionario nulo");
	         FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	         Funcionario tFuncionario = tDao.update(pFuncionario);
	         if (tFuncionario == null)
	             return new FuncionarioDTO(false, "Funcionario não existe no cadastro");

	         return new FuncionarioDTO(true, "Funcionario regravado com sucesso", tFuncionario);
	    }

	    // Método para deletar um usuário
	    public static FuncionarioDTO remover(int id) {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        if (! tDao.delete(id))
	            return new FuncionarioDTO(false, "Funcionario não existe no cadastro");
	        return new FuncionarioDTO(true, "Funcionario removido com sucesso");
	    }

	    // Método para pesquisar todos os usuários
	    public static FuncionarioDTO pesquisar() {
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        List<Funcionario> tLista = tDao.search();
	        if (tLista.isEmpty())
	            return new FuncionarioDTO(false, "Lista vazia");
	        return new FuncionarioDTO(true, "Lista de Funcionarios", tLista);
	    }

	    // Método para pesquisar por nome todos os usuários
	    public static FuncionarioDTO pesquisarPorFuncionario(String pFuncionario) {
	        if (pFuncionario == null)
	            return pesquisar();
	        FuncionarioDAO tDao = DaoFactory.getFuncionarioDAO();
	        List<Funcionario> tLista = tDao.searchByFuncionario(pFuncionario);
	        if (tLista.isEmpty())
	            return new FuncionarioDTO(false, "Nenhum registro encontrado com Companhia '" + pFuncionario + "'");
	        return new FuncionarioDTO(true, "Lista de Funcionarioes", tLista);
	    }

	    // Método para pesquisar verificar usuarios ativos.
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
