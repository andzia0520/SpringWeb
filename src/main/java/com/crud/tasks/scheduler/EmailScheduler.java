package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Tasks: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;


    @Autowired
    private AdminConfig adminConfig;


    private String createMessage(long size) {
        return "Currently in database you got: " + size + (size == 1 ? " task" : " tasks");
    }

    @Scheduled(/*fixedDelay = 10000*/ cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                createMessage(taskRepository.count())));
    }
}
