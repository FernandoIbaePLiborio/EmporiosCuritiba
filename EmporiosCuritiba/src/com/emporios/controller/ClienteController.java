package com.emporios.controller;

import java.util.List;

import com.emporios.daointerface.ClienteDAO;
import com.emporios.daointerface.DaoFactory;
import com.emporios.dto.ClienteDTO;
import com.emporios.model.Cliente;

public class ClienteController {
	// Método para criar um usuário
	public static ClienteDTO cadastrar(Cliente pCliente) {
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		if (pCliente == null)
			return new ClienteDTO(false, "Tentativa de inserir um cliente nulo");
		
		// Envia o objeto para fazer a verificação se já existe um cliente, caso não exita passa para a próxima validação.
		List<Cliente> tLista = tDao.search();
		for (Cliente cliente : tLista) {
			if(cliente.getAutenticacao().getId() == pCliente.getAutenticacao().getId()){
				return new ClienteDTO(true, "Voce já possui um cadastro!!! Deseja modificar?"+ cliente);
			}	
		}
		
		Cliente tCliente = tDao.create(pCliente);
		if (tCliente == null)
			return new ClienteDTO(false, "Problemas na gravação do cliente");

		return new ClienteDTO(true, "Cliente gravado com sucesso", tCliente);
	}
	
	// Método para recuperar um usuário através do id
	public static ClienteDTO recuperar(int id) {
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		Cliente tCliente = tDao.recovery(id);
		if (tCliente == null)
			return new ClienteDTO(false, "Cliente não existe no cadastro");

		return new ClienteDTO(true, "Cliente lido com sucesso", tCliente);
	}

	// Método para atualizar um usuário
	public static ClienteDTO atualizar(Cliente pCliente) {
		if (pCliente == null)
			return new ClienteDTO(false, "Tentativa de atualizar um cliente nulo");
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		Cliente tCliente = tDao.update(pCliente);
		if (tCliente == null)
			return new ClienteDTO(false, "Cliente não existe no cadastro");

		return new ClienteDTO(true, "Cliente regravado com sucesso", tCliente);
	}

	// Método para deletar um usuário
	public static ClienteDTO remover(int id) {
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		if (!tDao.delete(id))
			return new ClienteDTO(false, "Cliente não existe no cadastro");

		return new ClienteDTO(true, "Cliente removido com sucesso");
	}

	// Método para pesquisar todos os usuários
	public static ClienteDTO pesquisar() {
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		List<Cliente> tLista = tDao.search();
		if (tLista.isEmpty())
			return new ClienteDTO(false, "Lista de clientes vazia");

		return new ClienteDTO(true, "Lista de clientes recuperada", tLista);
	}

	// Método para pesquisar por nome todos os usuários
	public static ClienteDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		List<Cliente> tLista = tDao.searchByNome(pNome);
		if (tLista.isEmpty())
			return new ClienteDTO(false, "Nenhum registro encontrado com cliente '" + pNome + "'");

		return new ClienteDTO(true, "Lista de clientes recuperada", tLista);
	}

	// Método para pesquisar usuario por CPF
	public static ClienteDTO pesquisarPorCpf(String pCpf) {
		if (pCpf == null)
			return pesquisar();
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		List<Cliente> tLista = tDao.searchByCpf(pCpf);

		if (tLista.isEmpty())
			return new ClienteDTO(false, "Nenhum registro encontrado com CPF '" + pCpf + "'");

		return new ClienteDTO(true, "Lista de clientes recuperada", tLista);
	}
	
	/*private static ClienteDTO recuperarClienteUsu(Cliente pCliente) {
		ClienteDAO tDao = DaoFactory.getClienteDAO();
		List<Cliente> tLista = tDao.search();
		for (Cliente cliente : tLista) {
			if(cliente.getAutenticacao().getId() == pCliente.getAutenticacao().getId()){
				return new ClienteDTO(true, "Cliente lido com sucesso"+ cliente);
			}	
		}
		return new ClienteDTO(false, "Cliente não encontrado", pCliente);
	}*/
}
