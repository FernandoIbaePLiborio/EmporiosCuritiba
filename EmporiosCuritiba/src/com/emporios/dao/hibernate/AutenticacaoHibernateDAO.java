package com.emporios.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import com.emporios.daointerface.AutenticacaoDAO;
import com.emporios.hibernate.HibernateUtil;
import com.emporios.model.Autenticacao;
import com.emporios.util.ExceptionUtil;

public class AutenticacaoHibernateDAO implements AutenticacaoDAO {

	@Override
	public Autenticacao create(Autenticacao pAutenticacao) {
		try {
			pAutenticacao.setNivel('C');
			pAutenticacao.setDataCadastro(new Date());
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.save(pAutenticacao);
			tSessao.flush();
			return pAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de cria��o");
		}
		return null;
	}

	@Override
	public Autenticacao recovery(int pId) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query query = tSessao.createQuery("select a from Autenticacao a where a.id = :pId");
			query.setParameter("pId", pId);
			Autenticacao tAutenticacao = (Autenticacao) query.uniqueResult();
			return tAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o");
		}
		return null;
	}

	// M�todo para atualizar um autenticacao na base de dados (UPDATE)
	@Override
	public Autenticacao update(Autenticacao pAutenticacao) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.merge(pAutenticacao);
			tSessao.flush();
			return pAutenticacao;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o");
		}
		return null;
	}

	// M�todo para deletar um autenticacao na base de dados (DELETE)

	@Override
	public boolean delete(int pMatricula) {
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			tSessao.delete(tSessao.get(Autenticacao.class, pMatricula));
			tSessao.flush();
			return true;
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do autenticacao");
		}

		return false;
	}

	// M�todo para pesquisar todos os usu�rios da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> search() {
		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Query tQuery = tSessao.createQuery("FROM AUTENTICACAO");
			tLista = tQuery.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista de autenticacao");
		}

		return tLista;
	}

	// M�todo para pesquisar por nome todos os autenticacaos da base de dados
	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> searchByNome(String pNome) {
		String tNomePesquisa = "%" + pNome.toUpperCase() + "%";

		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Autenticacao.class)
					.add(Restrictions.like("nome", tNomePesquisa).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> searchByEmail(String pEmail) {
		List<Autenticacao> tLista = new ArrayList<>();
		try {
			SessionFactory tFactory = HibernateUtil.getSessionFactory();
			Session tSessao = tFactory.getCurrentSession();
			Criteria tCriterio = tSessao.createCriteria(Autenticacao.class)
					.add(Restrictions.like("email", pEmail).ignoreCase());
			tLista = tCriterio.list();
		} catch (HibernateException tExcept) {
			ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o da lista.");
		}
		return tLista;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Autenticacao> validar(Autenticacao pAutenticacao) {
		List<Autenticacao> tLista = new ArrayList<>();
		SessionFactory tFactory = HibernateUtil.getSessionFactory();
		Session tSessao = tFactory.getCurrentSession();
		Criteria tCriterio = tSessao.createCriteria(Autenticacao.class);
		tCriterio.add(Restrictions.eq("email", pAutenticacao.getEmail()));
		tCriterio.add(Restrictions.eq("senha", pAutenticacao.getSenha()));
		tCriterio.uniqueResult();
		pAutenticacao = null;
		tLista = tCriterio.list();
		return tLista;
	}
}
