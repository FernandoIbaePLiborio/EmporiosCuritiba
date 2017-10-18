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

import com.emporios.controller.ProdutoFornecedorController;
import com.emporios.dto.ProdutoFornecedorDTO;
import com.emporios.model.ProdutoFornecedor;

@Path("/Produto_Fornecedor")
public class ProdutoFornecedorWebService {
	
	    @POST
	    @Path("/Criar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO cadastrar(ProdutoFornecedor pProduto_Fornecedor)                                                            	                              
	    {
	    	return ProdutoFornecedorController.cadastrar(pProduto_Fornecedor);
	    }

	    @GET
	    @Path("/Recuperar/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO cadastrar(@PathParam("matricula") int id)
	    {
	    	return  ProdutoFornecedorController.recuperar(id);
	    }

	    @PUT
	    @Path("/Atualizar")
	    @Produces(MediaType.APPLICATION_JSON)
	    @Consumes(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO atualizar(ProdutoFornecedor pProduto_Fornecedor) 
	    {
	    	return ProdutoFornecedorController.atualizar(pProduto_Fornecedor);
	    }

	    @DELETE
	    @Path("/Remover/{matricula}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO remover(@PathParam("matricula") int id)
	    {
	    	return ProdutoFornecedorController.remover(id);
	    }

	    @GET
	    @Path("/Pesquisar")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO pesquisar()
	    {
	    	return ProdutoFornecedorController.pesquisar();
	    }
	    
	    // Recebe o 
	    @GET 
	    @Path("/ProdutosLoja/{fornecedor}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO pesquisarProdutos(@PathParam("fornecedor") int pFornecedor)
	    {
	    	return ProdutoFornecedorController.pesquisarProdutos(pFornecedor);
	    }
	    
	    @GET
	    @Path("/PesquisarCategFornec/{categoria}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO pesquisarCategoria(@PathParam("categoria") String pCategoria_Fornecedor)
	    {
	    	return ProdutoFornecedorController.pesquisarCategoria(pCategoria_Fornecedor);
	    }

	    @GET
	    @Path("/PesquisarPorNome/{produto}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO pesquisarPorFornecedor(@PathParam("produto") String pProduto)
	    {
	        return ProdutoFornecedorController.pesquisarPorFornecedor(pProduto);
	    }
	    
	    @GET
	    @Path("/VendaSemanal")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO VendaSemanal()
	    {
	        return ProdutoFornecedorController.pesquisaVendaSemanal();
	    }
	    
	    @GET
	    @Path("/RelatorioProdutoFornecedor")
	    @Produces(MediaType.APPLICATION_JSON)
	    public ProdutoFornecedorDTO produtoPorFornecedor()
	    {
	        return ProdutoFornecedorController.produtoPorFornecedor();
	    }
}
