package com.emporios.daointerface;

import java.util.List;

import com.emporios.model.Autenticacao;

public interface AutenticacaoDAO {
	
	// Método para criar um usuário na base de dados (INSERT)
    Autenticacao create(Autenticacao pAutenticacao);

    // Método para recuperar um usuário da base de dados (SELECT)
    Autenticacao recovery(int id);

    // Método para atualizar um usuário na base de dados (UPDATE)
    Autenticacao update(Autenticacao pAutenticacao);

    // Método para deletar um usuário na base de dados (DELETE)
    boolean delete(int id);
    
    // Método para validar Email e senha no Banco 
    List<Autenticacao> validar(Autenticacao pAutenticacao);

    // Método para pesquisar todos os usuários da base de dados
    List<Autenticacao> search();

    // Método para pesquisar por nome todos os usuários da base de dados
    List<Autenticacao> searchByNome(String pNome);

    // Método para pesquisar por email todos os usuários da base de dados
    List<Autenticacao> searchByEmail(String pEmail);
}
