
package br.com.atmz.commons.mail;

import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class MailTemplateParser {
	
	private static final String PATH_TEMPLATES = "mailTemplates/";
	
	private SpringTemplateEngine templateEngine;
	
	public MailTemplateParser(SpringTemplateEngine templateEngine) {
		this.templateEngine = templateEngine;
	}
	
	public String parse(MailMessage mailMessage) {
		Context context = new Context();
		
		context.setVariables(mailMessage.getMailMapParam());
		
		setUpVariables(context, mailMessage);
		
		return templateEngine.process(PATH_TEMPLATES + mailMessage.getType().getTemplate(), context);
	}
	private void setUpVariables(Context context, MailMessage mailMessage) {
		context.setVariables(mailMessage.getMailMapParam());
	}
}
