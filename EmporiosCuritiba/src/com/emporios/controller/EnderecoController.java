package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.EnderecoDAO;
import com.emporios.dto.EnderecoDTO;
import com.emporios.model.Endereco;

public class EnderecoController
{
	 // M�todo para criar o usu�rio
	 public static EnderecoDTO cadastrar(Endereco pEndereco) {
		 if (pEndereco == null)
	            return new EnderecoDTO(false, "Tentativa de inserir um endere�o nulo");
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        Endereco tEndereco = tDao.create(pEndereco);
	        if (tEndereco == null)
	            return new EnderecoDTO(false, "Problemas na grava��o do endere�o");

	        return new EnderecoDTO(true, "Endere�o gravado com sucesso", tEndereco);
	    }
	 // M�todo para recuperar um endere�o
	    public static EnderecoDTO recuperar(int id) {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        Endereco tEndereco = tDao.recovery(id);
	        if (tEndereco == null)
	            return new EnderecoDTO(false, "Endere�o n�o existe no cadastro");

	        return new EnderecoDTO(true, "Endere�o lido com sucesso", tEndereco);
	    }

	    // M�todo para atualizar um endere�o
	    public static EnderecoDTO atualizar(Endereco pEndereco) {
	    	 if (pEndereco == null)
	             return new EnderecoDTO(false, "Tentativa de atualizar um endere�o nulo");

	         EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	         Endereco tEndereco = tDao.update(pEndereco);
	         if (tEndereco == null)
	             return new EnderecoDTO(false, "Endere�o n�o existe no cadastro");

	         return new EnderecoDTO(true, "Endere�o regravado com sucesso", tEndereco);
	    }

	    // M�todo para deletar um endere�o
	    public static EnderecoDTO remover(int id) {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        if (! tDao.delete(id))
	            return new EnderecoDTO(false, "Endere�o n�o existe no cadastro");

	        return new EnderecoDTO(true, "Endere�o removido com sucesso");
	    }

	    // M�todo para pesquisar todos os endere�os
	    public static EnderecoDTO pesquisar() {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.search();

	        if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Lista de endere�os est� em branco");

	        return new EnderecoDTO(true, "Lista de endere�os", tLista);
	    }

	    // M�todo para pesquisar por nome todos os endere�os
	    public static EnderecoDTO pesquisarPorRua(String pRua) {
	        if (pRua == null)
	            return pesquisar();
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.searchByRua(pRua);
	        
	        if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Nenhum registro encontrado com essa rua '" + pRua + "'");

	        return new EnderecoDTO(true, "Lista de endere�os", tLista);
	    }

	    // M�todo para pesquisar por Cep todos os endere�os
	    public static EnderecoDTO pesquisarPorCep(String pCep) {
	        if (pCep == null)
	            return pesquisar();

	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.searchByCep(pCep);

	       if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Nenhum registro encontrado com Cep '" + pCep + "'");

	        return new EnderecoDTO(true, "Lista de Endere�os", tLista);
	    }
	}
