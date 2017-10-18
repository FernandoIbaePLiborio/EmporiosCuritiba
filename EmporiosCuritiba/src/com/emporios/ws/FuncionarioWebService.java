package com.emporios.ws;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emporios.controller.FuncionarioController;
import com.emporios.dto.FuncionarioDTO;
import com.emporios.model.Funcionario;

@Path("/Funcionario")
public class FuncionarioWebService {

	 //private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO cadastrar(Funcionario pFuncionario)
	    {
	    	return FuncionarioController.cadastrar(pFuncionario);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  FuncionarioController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO atualizar(Funcionario pFuncionario)
	    {
	    	return FuncionarioController.atualizar(pFuncionario);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO remover(@PathParam("matricula") int id)
	    {
	    	return FuncionarioController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO pesquisar()
	    {
	    	return FuncionarioController.pesquisar();
	    }

	    @GET
	    @Path("/PesquisarPorFuncionario/{funcionario}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO pesquisarPorFuncionario(@PathParam("funcionario") String pFuncionario)
	    {
	    	return FuncionarioController.pesquisarPorFuncionario(pFuncionario);
	    }

	    @GET
	    @Path("/PesquisarPorAtivo/{ativo}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FuncionarioDTO pesquisarPorAtivo(@PathParam("ativo") char pAtivo)
	    {
	        return FuncionarioController.pesquisarPorAtivo(pAtivo);
	    }
}
