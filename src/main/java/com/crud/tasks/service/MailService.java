package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final String QTY_EMAIL_SUBJECT = "Tasks: Once a day email";
    private static final String CREATED_TRELLOCARD_SUBJECT = "New TrelloCard";
    @Autowired
    private MailCreatorService mailCreatorService;

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    public void sendQtyEmail(long tasksCount) {
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                QTY_EMAIL_SUBJECT,
                mailCreatorService.buildTasksQtyEmail("Currently in database you got: " + tasksCount + (tasksCount == 1 ? " task" : " tasks"))));
    }

    public void sendCreatedTrelloCardEmail() {
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                CREATED_TRELLOCARD_SUBJECT,
                mailCreatorService.buildTrelloCardEmail("New card has been created")));
    }
}
