package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.DaoFactory;
import com.emporios.daointerface.EnderecoDAO;
import com.emporios.dto.EnderecoDTO;
import com.emporios.model.Endereco;

public class EnderecoController
{
	 // Método para criar o usuário
	 public static EnderecoDTO cadastrar(Endereco pEndereco) {
		 if (pEndereco == null)
	            return new EnderecoDTO(false, "Tentativa de inserir um endereço nulo");
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        Endereco tEndereco = tDao.create(pEndereco);
	        if (tEndereco == null)
	            return new EnderecoDTO(false, "Problemas na gravação do endereço");

	        return new EnderecoDTO(true, "Endereço gravado com sucesso", tEndereco);
	    }
	 // Método para recuperar um endereço
	    public static EnderecoDTO recuperar(int id) {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        Endereco tEndereco = tDao.recovery(id);
	        if (tEndereco == null)
	            return new EnderecoDTO(false, "Endereço não existe no cadastro");

	        return new EnderecoDTO(true, "Endereço lido com sucesso", tEndereco);
	    }

	    // Método para atualizar um endereço
	    public static EnderecoDTO atualizar(Endereco pEndereco) {
	    	 if (pEndereco == null)
	             return new EnderecoDTO(false, "Tentativa de atualizar um endereço nulo");

	         EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	         Endereco tEndereco = tDao.update(pEndereco);
	         if (tEndereco == null)
	             return new EnderecoDTO(false, "Endereço não existe no cadastro");

	         return new EnderecoDTO(true, "Endereço regravado com sucesso", tEndereco);
	    }

	    // Método para deletar um endereço
	    public static EnderecoDTO remover(int id) {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        if (! tDao.delete(id))
	            return new EnderecoDTO(false, "Endereço não existe no cadastro");

	        return new EnderecoDTO(true, "Endereço removido com sucesso");
	    }

	    // Método para pesquisar todos os endereços
	    public static EnderecoDTO pesquisar() {
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.search();

	        if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Lista de endereços está em branco");

	        return new EnderecoDTO(true, "Lista de endereços", tLista);
	    }

	    // Método para pesquisar por nome todos os endereços
	    public static EnderecoDTO pesquisarPorRua(String pRua) {
	        if (pRua == null)
	            return pesquisar();
	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.searchByRua(pRua);
	        
	        if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Nenhum registro encontrado com essa rua '" + pRua + "'");

	        return new EnderecoDTO(true, "Lista de endereços", tLista);
	    }

	    // Método para pesquisar por Cep todos os endereços
	    public static EnderecoDTO pesquisarPorCep(String pCep) {
	        if (pCep == null)
	            return pesquisar();

	        EnderecoDAO tDao = DaoFactory.getEnderecoDAO();
	        List<Endereco> tLista = tDao.searchByCep(pCep);

	       if (tLista.isEmpty())
	            return new EnderecoDTO(false, "Nenhum registro encontrado com Cep '" + pCep + "'");

	        return new EnderecoDTO(true, "Lista de Endereços", tLista);
	    }
	}
