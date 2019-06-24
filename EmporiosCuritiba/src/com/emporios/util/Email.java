package com.emporios.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	public static void envioEmail(String email) {
		String tSenha = obterSenha();
		if (tSenha.isEmpty())
			return;

		String tServidor = "smtp.gmail.com";
		String tPorta = "465";
		String tUsuario = "emporiosaudecuritiba@gmail.com";

		String tDestino = email;
		String tOrigem = "emporiosaudecuritiba@gmail.com";

		Properties tPropriedades = new Properties();
		tPropriedades.put("mail.smtp.host", tServidor);
		tPropriedades.put("mail.smtp.user", tUsuario);
		tPropriedades.put("mail.smtp.auth", "true");
		tPropriedades.put("mail.smtp.port", tPorta);
		tPropriedades.put("mail.smtp.ssl.enable", "true");
		tPropriedades.put("mail.smtp.debug", "true");
		tPropriedades.put("mail.smtp.socketFactory.port", tPorta);
		tPropriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		// tPropriedades.put("mail.smtp.socketFactory.fallback", "false");
		// tPropriedades.put("mail.smtp.starttls.enable", "true");
		
		// Obtendo o objeto Session
		Session tSessao = Session.getDefaultInstance(tPropriedades, new Autenticador(tUsuario, tSenha));
		try {
			// Criando a mensagem
			Message tMensagem = new MimeMessage(tSessao);

			// Configurando a mensagem.
			tMensagem.setFrom(new InternetAddress(tOrigem));
			tMensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(tDestino));
			tMensagem.setSubject("Emporios Curitiba");
			tMensagem.setText("		Empório Curitiba fica feliz em receber você.\n\n"
					+"Contatos: (41) 9 9983-0281\n"
					+"Idealizador: https://fernandoibaepliborio.github.io/profile.github.io");

			// Enviando a mensagem
			Transport.send(tMensagem);

			System.out.println("E-mail enviado com sucesso....");
		} catch (MessagingException tExcept) {
			throw new RuntimeException(tExcept);
		}
	}	

	private static String obterSenha() {
		String email = "emporiosaudecuritiba@gmail.com";
		String senha = "senhapadrão";
		PasswordAuthentication tSenha = new PasswordAuthentication(email, senha);
		char[] tSenhaCh = tSenha.getPassword().toCharArray();
		return new String(tSenhaCh);
	}

	private static class Autenticador extends Authenticator {

		private String mUsuario;
		private String mSenha;

		public Autenticador(String pUsuario, String pSenha) {
			super();
			mUsuario = pUsuario;
			mSenha = pSenha;
		}

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(mUsuario, mSenha);
		}
	}
}
