package br.com.atmz.commons.mail;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AsyncMailService implements MailService {

	@Autowired
	private MailSenderFactory mailSender;

	@Override
	public void send(MailMessage mailMessage) {
		CompletableFuture.supplyAsync(() -> mailSender.send(mailMessage));
	}
}
