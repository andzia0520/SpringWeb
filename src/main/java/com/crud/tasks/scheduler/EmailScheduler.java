package com.crud.tasks.scheduler;

import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailScheduler {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private MailService mailService;

    @Scheduled(fixedDelay = 10000/* cron = "0 0 10 * * *"*/)
    public void sendInformationEmail() {
        mailService.sendQtyEmail(taskRepository.count());
        mailService.sendCreatedTrelloCardEmail();
    }
}
