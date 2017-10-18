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

import com.emporios.controller.Produto_FornecedorController;
import com.emporios.dto.Produto_FornecedorDTO;
import com.emporios.model.Produto_Fornecedor;

@Path("/Produto_Fornecedor")
public class Produto_FornecedorWebService {
	
	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO cadastrar(Produto_Fornecedor pProduto_Fornecedor)                                                            	                              
	    {
	    	return Produto_FornecedorController.cadastrar(pProduto_Fornecedor);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  Produto_FornecedorController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO atualizar(Produto_Fornecedor pProduto_Fornecedor) 
	    {
	    	return Produto_FornecedorController.atualizar(pProduto_Fornecedor);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO remover(@PathParam("matricula") int id)
	    {
	    	return Produto_FornecedorController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO pesquisar()
	    {
	    	return Produto_FornecedorController.pesquisar();
	    }
	    
	    // Recebe o 
	    @GET 
	    @Path("/ProdutosLoja/{fornecedor}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO pesquisarProdutos(@PathParam("fornecedor") int pFornecedor)
	    {
	    	return Produto_FornecedorController.pesquisarProdutos(pFornecedor);
	    }
	    
	    @GET
	    @Path("/PesquisarCategFornec/{categoria}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO pesquisarCategoria(@PathParam("categoria") String pCategoria_Fornecedor)
	    {
	    	return Produto_FornecedorController.pesquisarCategoria(pCategoria_Fornecedor);
	    }

	    @GET
	    @Path("/PesquisarPorNome/{produto}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO pesquisarPorFornecedor(@PathParam("produto") String pProduto)
	    {
	        return Produto_FornecedorController.pesquisarPorFornecedor(pProduto);
	    }
	    
	    @GET
	    @Path("/VendaSemanal")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO VendaSemanal()
	    {
	        return Produto_FornecedorController.pesquisaVendaSemanal();
	    }
	    
	    @GET
	    @Path("/RelatorioProdutoFornecedor")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Produto_FornecedorDTO produtoPorFornecedor()
	    {
	        return Produto_FornecedorController.produtoPorFornecedor();
	    }
}
