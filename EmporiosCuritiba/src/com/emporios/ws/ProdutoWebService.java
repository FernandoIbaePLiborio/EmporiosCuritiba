package com.emporios.ws;

//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
//import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.emporios.controller.ProdutoController;
import com.emporios.dto.ProdutoDTO;
import com.emporios.model.Produto;


@Path("/Produto")
public class ProdutoWebService {

	 //private SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public ProdutoDTO cadastrar(Produto pProduto)
	    {
	    	return ProdutoController.cadastrar(pProduto);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  ProdutoController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public ProdutoDTO atualizar(Produto pProduto)
	    {
	    	return ProdutoController.atualizar(pProduto);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoDTO remover(@PathParam("matricula") int id)
	    {
	    	return ProdutoController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoDTO pesquisar()
	    {
	    	return ProdutoController.pesquisar();
	    }


	    @GET
	    @Path("/PesquisarPorNome/{nome}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoDTO pesquisarPorNome(@PathParam("nome") String pNome)
	    {
	        return ProdutoController.pesquisarPorNome(pNome);
	    }

}
