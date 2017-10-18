package com.emporios.ws;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.emporios.controller.ClienteController;
import com.emporios.dto.ClienteDTO;
import com.emporios.enums.NivelAcesso;
import com.emporios.model.Autenticacao;
import com.emporios.model.Cliente;

@Path("/Cliente")
public class ClienteWebService {

	private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	@POST
	@Path("/Criar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClienteDTO cadastrar(Cliente pCliente, @Context HttpServletRequest pRequest) {
		HttpSession tSessao = pRequest.getSession(false);
		if (tSessao != null) {
			try {
				Autenticacao pAutenticacao = (Autenticacao) tSessao.getAttribute("AUTENTICACAO");
				if (pAutenticacao.getNivel() != NivelAcesso.CLIENTE.getCodigo()) {
					return new ClienteDTO(false,
							"Seja bem vindo!!! E necessário ter um perfil cliente para cadastro, por favor tente cadastrar outro email.! "
									+ pAutenticacao.getEmail());
				} else {
					String data = formatador.format(pCliente.getDataNascimento());
					Date data2 = formatador.parse(data);
					pCliente.setDataNascimento(data2);
					pCliente.getCelular().replaceAll("\\D", "");
					pCliente.getFone().replaceAll("\\D", "");
					pCliente.setAutenticacao(pAutenticacao);
					return ClienteController.cadastrar(pCliente);
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return new ClienteDTO(false, "Seja muito bem vindo!!! Cadastre seu email ou faça o login no topo direito da página");
	}

	@GET
	@Path("/Recuperar/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO cadastrar(@PathParam("id") int id) {
		return ClienteController.recuperar(id);
	}

	@PUT
	@Path("/Atualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClienteDTO atualizar(Cliente pCliente) {
		return ClienteController.atualizar(pCliente);
	}

	@DELETE
	@Path("/Remover/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO remover(@PathParam("Id") int id) {
		return ClienteController.remover(id);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO pesquisar() {
		return ClienteController.pesquisar();
	}

	@GET
	@Path("/PesquisarPorCpf/{CPF}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO pesquisarPorCpf(@PathParam("CPF") String pCpf) {
		return ClienteController.pesquisarPorCpf(pCpf);
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public ClienteDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return ClienteController.pesquisarPorNome(pNome);
	}

}
