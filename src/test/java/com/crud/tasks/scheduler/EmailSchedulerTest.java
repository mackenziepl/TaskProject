package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EmailSchedulerTest {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Test
    public void sendInformationEmail() {
        long size = 2;
        String link = " task";
        if(size > 1) {
            link = " tasks";
        }

        Mail mail = new Mail("mack.kodilla@gmail.com", "Tasks: Once a day email",
                "Currently in database you got: " + size + link);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        simpleEmailService.send(ArgumentMatchers.any(Mail.class));

        verify(simpleEmailService, times(1)).send(ArgumentMatchers.any(Mail.class));
//        verify(javaMailSender, times(1)).send(mailMessage);
    }
}