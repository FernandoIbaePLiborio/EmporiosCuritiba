package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Categoria;

public interface CategoriaDAO {

	// M�todo para criar um usu�rio na base de dados (INSERT)
    Categoria create(Categoria pCategoria);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Categoria recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Categoria update(Categoria pCategoria);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Categoria> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Categoria> searchByNome(String pNome);
}
