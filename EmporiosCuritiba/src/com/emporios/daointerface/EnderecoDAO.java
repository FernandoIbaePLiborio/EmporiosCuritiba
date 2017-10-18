package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Endereco;


public interface EnderecoDAO {
	
	// M�todo para criar um usu�rio na base de dados (INSERT)
    Endereco create(Endereco pEndereco);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Endereco recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Endereco update(Endereco pEndereco);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Endereco> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Endereco> searchByRua(String pRua);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<Endereco> searchByCep(String pCep);

}
