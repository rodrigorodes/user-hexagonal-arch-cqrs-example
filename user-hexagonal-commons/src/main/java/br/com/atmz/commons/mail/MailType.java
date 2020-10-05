
package br.com.atmz.commons.mail;

public enum MailType {

	USER_REGISTRED("user_registred", "user-registred.html",	"Novo Registro");

	private final String type;
	private final String template;
	private final String subject;

	private MailType(String type, String template, String subject) {
		this.type = type;
		this.template = template;
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public String getSubject() {
		return subject;
	}

	public String getTemplate() {
		return template;
	}

}
