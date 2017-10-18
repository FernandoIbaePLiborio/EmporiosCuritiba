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
import com.emporios.controller.CategoriaController;
import com.emporios.dto.CategoriaDTO;
import com.emporios.model.Categoria;

@Path("/Categoria")
public class CategoriaWebService {

	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public CategoriaDTO cadastrar(Categoria pCategoria)
	    {
	    	return CategoriaController.cadastrar(pCategoria);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CategoriaDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  CategoriaController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public CategoriaDTO atualizar(Categoria pCategoria)
	    {
	    	return CategoriaController.atualizar(pCategoria);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CategoriaDTO remover(@PathParam("matricula") int id)
	    {
	    	return CategoriaController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CategoriaDTO pesquisar()
	    {
	    	return CategoriaController.pesquisar();
	    }

	    @GET
	    @Path("/PesquisarPorNome/{nome}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public CategoriaDTO pesquisarPorNome(@PathParam("nome") String pNome)
	    {
	        return CategoriaController.pesquisarPorNome(pNome);
	    }

}
