package br.com.atmz.adapter.user.notifications.listeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.atmz.commons.mail.MailMessage;
import br.com.atmz.commons.mail.MailService;
import br.com.atmz.commons.mail.MailType;
import br.com.atmz.user.write.application.commands.update.UpdateUserRepresentation;
import br.com.atmz.user.write.application.events.UpdateUserEvent;

@Component
public class MailUpdateUserEventListener {

	@Autowired
	private MailService sender;

    @EventListener
	public void onApplicationEvent(UpdateUserEvent event) {
    	UpdateUserRepresentation createUserRepresentation = event.getWhat();
		MailMessage mailMessageCreate = MailMessage.of(createUserRepresentation.getUser().getMail(), MailType.USER_REGISTRED);
		mailMessageCreate.addMailParam("title", MailType.USER_REGISTRED.getSubject());
		sender.send(mailMessageCreate);
	}
}
