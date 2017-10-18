package com.emporios.ws;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.emporios.controller.AutenticacaoController;
import com.emporios.dto.AutenticacaoDTO;
import com.emporios.enums.NivelAcesso;
import com.emporios.model.Autenticacao;
import com.emporios.util.Validador;

@Named
@SessionScoped
@Path("/Autenticacao")
public class UsuarioWebService implements Serializable {
	private static final long serialVersionUID = 5722467048090760478L;

	private Autenticacao usuarioLogado;

	@POST
	@Path("/Criar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO cadastrar(Autenticacao pAutenticacao) {
		return AutenticacaoController.cadastrar(pAutenticacao);
	}

	@GET
	@Path("/Recuperar/{matricula}")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO getRecuperar(@Context HttpServletRequest pRequest, @PathParam("matricula") int id) {
		HttpSession tSessao = pRequest.getSession(false);
		if (tSessao != null) {
			try {
				Autenticacao pAutenticacao = (Autenticacao) tSessao.getAttribute("AUTENTICACAO");
				Validador.USUARIO_AUTENTICADO = pAutenticacao.getEmail();
				if (pAutenticacao.getNivel() == NivelAcesso.ADMINISTRADOR.getCodigo())
					return AutenticacaoController.recuperar(id);
				;
				return new AutenticacaoDTO(false, "Acesso negado para esta requisição" + pAutenticacao.getEmail());
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return new AutenticacaoDTO(false, "Acesso negado! Entre em contato com administrador.");
	}

	@PUT
	@Path("/Atualizar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO atualizar(Autenticacao pAutenticacao) {
		return AutenticacaoController.atualizar(pAutenticacao);
	}

	@DELETE
	@Path("/Remover/{matricula}")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO remover(@PathParam("matricula") int id) {
		return AutenticacaoController.remover(id);
	}

	@GET
	@Path("/Pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO pesquisar(@Context HttpServletRequest pRequest) {

		HttpSession tSessao = pRequest.getSession(false);
		if (tSessao != null) {
			try {
				Autenticacao pAutenticacao = (Autenticacao) tSessao.getAttribute("AUTENTICACAO");
				// Validador.USUARIO_AUTENTICADO = pAutenticacao.getEmail();
				if (pAutenticacao.getNivel() == NivelAcesso.ADMINISTRADOR.getCodigo())
					return AutenticacaoController.pesquisar();

				return new AutenticacaoDTO(false, "Acesso negado para esta requisição" + pAutenticacao.getEmail());
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return new AutenticacaoDTO(false, "Acesso negado! Entre em contato com administrador.");
	}

	@GET
	@Path("/PesquisarPorEmail/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO pesquisarPorEmail(@PathParam("email") String pEmail) {
		return AutenticacaoController.pesquisarPorEmail(pEmail);
	}

	@GET
	@Path("/PesquisarPorNome/{nome}")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO pesquisarPorNome(@PathParam("nome") String pNome) {
		return AutenticacaoController.pesquisarPorNome(pNome);
	}

	@POST
	@Path("/Login")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO login(Autenticacao pAutenticacao, @Context HttpServletRequest request) {
		System.out.println(request.getSession().getId());
		if (AutenticacaoController.logar(pAutenticacao).isOk()) {
			HttpSession tSessao = request.getSession(true);
			Autenticacao usuario = AutenticacaoController.logar(pAutenticacao).getAutenticacao();
			tSessao.setAttribute("AUTENTICACAO", usuario);
			setUsuarioLogado(usuario);
			return new AutenticacaoDTO(true, usuario.getEmail() + " Seja bem vindo ao Emporios Curitiba");
		}
		return new AutenticacaoDTO(false, "Por favor, verifique seus dados " + pAutenticacao.getEmail());
	}

	@GET
	@Path("/ObterUsuarioLogado")
	@Produces(MediaType.APPLICATION_JSON)
	public AutenticacaoDTO getObterUsuarioLogado() {
		if (usuarioLogado != null) {
			if (AutenticacaoController.recuperar(usuarioLogado.getId()).isOk())
				return new AutenticacaoDTO(true, usuarioLogado.getEmail());
		}
		return new AutenticacaoDTO(false, "Login");
	}

	// getUsuarioLogado() != null ? getUsuarioLogado().getEmail():"a;djflksjdf";
	public Autenticacao getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Autenticacao usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}
