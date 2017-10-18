package com.emporios.controller;

import java.io.Serializable;
import java.util.List;

import com.emporios.daointerface.AutenticacaoDAO;
import com.emporios.daointerface.DaoFactory;
import com.emporios.dto.AutenticacaoDTO;
import com.emporios.model.Autenticacao;
import com.emporios.util.Validador;

public class AutenticacaoController implements Serializable {
	private static final long serialVersionUID = 1L;

	// Método para criar um usuário
	public static AutenticacaoDTO cadastrar(Autenticacao pAutenticacao) {
		if (pAutenticacao == null)
			return new AutenticacaoDTO(false, "Não é possível inserir dados nulos");

		if (pesquisarPorEmail(pAutenticacao.getEmail().trim()).isOk()){
			return new AutenticacaoDTO(false, "Já existe um cadastro com este email, escolha a opção login no topo da pagina ou acesse recurso: 'esqueci minha senha'");
		}

		if (!Validador.validarEmail(pAutenticacao.getEmail().trim()))
			return new AutenticacaoDTO(false, "O sistema requer um formato de email correto !!!");

		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		Autenticacao tAutenticacao = tDao.create(pAutenticacao);
		if (tAutenticacao == null) {
			return new AutenticacaoDTO(false, "Problemas na gravação de autenticação");
		} else {
			//Email.envioEmail(tAutenticacao.getEmail());
			return new AutenticacaoDTO(true, "Autenticação gravada com sucesso", tAutenticacao);
		}
	}

	// Método para recuperar um usuário
	public static AutenticacaoDTO recuperar(int id) {
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		Autenticacao tAutenticacao = tDao.recovery(id);

		if (tAutenticacao == null)
			return new AutenticacaoDTO(false, "Autenticação não existe no cadastro");

		return new AutenticacaoDTO(true, "Leitura de Autenticação", tAutenticacao);
	}

	// Método para atualizar um usuário
	public static AutenticacaoDTO atualizar(Autenticacao pAutenticacao) {
		if (pAutenticacao == null)
			return new AutenticacaoDTO(false, "Tentativa de atualização sem sucesso!");
		// Criptografia
		pAutenticacao.setSenha(MD5(pAutenticacao.getSenha()));
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		Autenticacao tAutenticacao = tDao.update(pAutenticacao);
		if (tAutenticacao == null)
			return new AutenticacaoDTO(false, "Autenticacao não existe no cadastro!");

		return new AutenticacaoDTO(true, "Autenticação regravada com sucesso", tAutenticacao);
	}

	// Método para deletar um usuário
	public static AutenticacaoDTO remover(int id) {
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		if (!tDao.delete(id))
			return new AutenticacaoDTO(false, "Autenticação não pode ser removida");
		return new AutenticacaoDTO(true, "Autenticação removida com sucesso!");
	}

	// Método para pesquisar todos os usuários
	public static AutenticacaoDTO pesquisar() {
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		List<Autenticacao> tLista = tDao.search();
		if (tLista.isEmpty())
			return new AutenticacaoDTO(false, "Lista vazia");

		return new AutenticacaoDTO(true, "Lista", tLista);
	}

	// Método para pesquisar por nome todos os usuários
	public static AutenticacaoDTO pesquisarPorNome(String pNome) {
		if (pNome == null)
			return pesquisar();
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		List<Autenticacao> tLista = tDao.searchByNome(pNome);
		if (tLista.isEmpty())
			return new AutenticacaoDTO(false, "Nenhum registro encontrado com nome '" + pNome + "'");

		return new AutenticacaoDTO(true, "Autenticação", tLista);
	}

	// Método para pesquisar os usuários por email
	public static AutenticacaoDTO pesquisarPorEmail(String pEmail) {
		if (pEmail == null)
			return pesquisar();

		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		List<Autenticacao> tLista = tDao.searchByEmail(pEmail);

		if (tLista.isEmpty())
			return new AutenticacaoDTO(false, "Nenhum registro encontrado com email '" + pEmail + "'");

		return new AutenticacaoDTO(true, "Autenticação", tLista);
	}

	// Verifica, retorna e mantém o usuário logado no sistema;
	public static AutenticacaoDTO logar(Autenticacao pAutenticacao) {
		AutenticacaoDAO tDao = DaoFactory.getAutenticacaoDAO();
		List<Autenticacao> tLista = tDao.validar(pAutenticacao);
		if (tLista.isEmpty()) {
			return new AutenticacaoDTO(false, "Dados não conferem para: '" + pAutenticacao.getEmail() + "'");
		}
		return new AutenticacaoDTO(true,"",tLista.get(0));
	}

	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
}
