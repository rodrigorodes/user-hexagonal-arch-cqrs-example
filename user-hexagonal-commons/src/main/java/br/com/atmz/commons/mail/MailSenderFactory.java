package br.com.atmz.commons.mail;

import java.nio.charset.StandardCharsets;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailSenderFactory {

	private JavaMailSender sender;
	private MailTemplateParser mailTemplateParser;

	public MailSenderFactory(JavaMailSender sender, MailTemplateParser mailTemplateParser) {
		this.sender = sender;
		this.mailTemplateParser = mailTemplateParser;
	}

	public boolean send(MailMessage mailMessage) {
		
		MimeMessage message = sender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());

			helper.setFrom(MailMessage.MAIL_FROM);
			helper.setTo(mailMessage.getTo());
			helper.setSubject(mailMessage.getSubject());
			helper.setText(mailTemplateParser.parse(mailMessage), true);
			sender.send(message);
			
			return true;
		} catch (MessagingException e1) {
			return false;
		}
	}

}
