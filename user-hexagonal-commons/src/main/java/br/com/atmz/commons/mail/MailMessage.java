package br.com.atmz.commons.mail;

public class MailMessage {

	public final static String MAIL_FROM = "cadastro@biblioteca-virtual.edu";

	private String to;
	private MailType type;
	private MailMapParam mailMapParam;

	private MailMessage(String to, MailType type) {
		this.to = to;
		this.type = type;
	}

	public static MailMessage of(String to, MailType type) {
		return new MailMessage(to, type);
	}

	public void addMailParam(String name, String value) {
		getMailMapParam().put(name, value);
	}

	public MailMapParam getMailMapParam() {
		if (mailMapParam == null) {
			mailMapParam = new MailMapParam();
		}
		return mailMapParam;
	}

	public String getTo() {
		return to;
	}

	public MailType getType() {
		return type;
	}

	public String getSubject() {
		return type.getSubject();
	}
}
