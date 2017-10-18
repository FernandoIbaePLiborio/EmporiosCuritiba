package com.emporios.ws;

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

import com.emporios.controller.EnderecoController;
import com.emporios.dto.EnderecoDTO;
import com.emporios.model.Autenticacao;
import com.emporios.model.Endereco;

@Path("/Endereco")
public class EnderecoWebService {
    @POST
    @Path("/Criar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EnderecoDTO cadastrar(Endereco pEndereco, @Context HttpServletRequest pRequest) {
    	HttpSession tSessao = pRequest.getSession(false);
		if (tSessao != null) {
			try {
				Autenticacao pAutenticacao = (Autenticacao) tSessao.getAttribute("AUTENTICACAO");
				pEndereco.setAutenticacao(pAutenticacao);
				return EnderecoController.cadastrar(pEndereco);
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return new EnderecoDTO(false, "Seja muito bem vindo!!! Cadastre seu email ou faça o login no topo direito da página");
    }

    @GET
    @Path("/Recuperar/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoDTO cadastrar(@PathParam("id") int id)
    {
    	return  EnderecoController.recuperar(id);
    }

    @PUT
    @Path("/Atualizar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public EnderecoDTO atualizar(Endereco pEndereco) 
    {
    	return EnderecoController.atualizar(pEndereco);
    }

    @DELETE
    @Path("/Remover/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoDTO remover(@PathParam("id") int id)
    {
    	return EnderecoController.remover(id);
    }

    @GET
    @Path("/Pesquisar")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoDTO pesquisar()
    {
    	return EnderecoController.pesquisar();
    }

    @GET
    @Path("/PesquisarPorCep/{cep}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoDTO pesquisarPorCnpj(@PathParam("cep") String pCep)
    {
    	return EnderecoController.pesquisarPorCep(pCep);
    }

    @GET
    @Path("/PesquisarPorRua/{rua}")
    @Produces(MediaType.APPLICATION_JSON)
    public EnderecoDTO pesquisarPorRua(@PathParam("rua") String pRua)
    {
        return EnderecoController.pesquisarPorRua(pRua);
    }
}
