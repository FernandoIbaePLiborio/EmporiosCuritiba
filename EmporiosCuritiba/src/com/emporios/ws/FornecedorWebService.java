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

import com.emporios.controller.FornecedorController;
import com.emporios.dto.FornecedorDTO;
import com.emporios.model.Fornecedor;

@Path("/Fornecedor")
public class FornecedorWebService {
	
	 //private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public FornecedorDTO cadastrar(Fornecedor pFornecedor)                                                            	                              
	    {
	    	return FornecedorController.cadastrar(pFornecedor);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FornecedorDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  FornecedorController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public FornecedorDTO atualizar(Fornecedor pFornecedor) 
	    {
	    	return FornecedorController.atualizar(pFornecedor);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FornecedorDTO remover(@PathParam("matricula") int id)
	    {
	    	return FornecedorController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FornecedorDTO pesquisar()
	    {
	    	return FornecedorController.pesquisar();
	    }

	    @GET
	    @Path("/PesquisarPorCnpj/{cnpj}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FornecedorDTO pesquisarPorCnpj(@PathParam("cnpj") String pCnpj)
	    {
	    	return FornecedorController.pesquisarPorCnpj(pCnpj);
	    }

	    @GET
	    @Path("/PesquisarPorNome/{companhia}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public FornecedorDTO pesquisarPorCompanhia(@PathParam("companhia") String pCompanhia)
	    {
	        return FornecedorController.pesquisarPorCompanhia(pCompanhia);
	    }

}
