package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Autenticacao;

public interface AutenticacaoDAO {
	
	// M�todo para criar um usu�rio na base de dados (INSERT)
    Autenticacao create(Autenticacao pAutenticacao);

    // M�todo para recuperar um usu�rio da base de dados (SELECT)
    Autenticacao recovery(int id);

    // M�todo para atualizar um usu�rio na base de dados (UPDATE)
    Autenticacao update(Autenticacao pAutenticacao);

    // M�todo para deletar um usu�rio na base de dados (DELETE)
    boolean delete(int id);
    
    // M�todo para validar Email e senha no Banco 
    List<Autenticacao> validar(Autenticacao pAutenticacao);

    // M�todo para pesquisar todos os usu�rios da base de dados
    List<Autenticacao> search();

    // M�todo para pesquisar por nome todos os usu�rios da base de dados
    List<Autenticacao> searchByNome(String pNome);

    // M�todo para pesquisar por email todos os usu�rios da base de dados
    List<Autenticacao> searchByEmail(String pEmail);
}
