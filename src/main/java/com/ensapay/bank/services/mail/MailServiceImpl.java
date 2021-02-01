package com.ensapay.bank.services.mail;


import com.ensapay.bank.Configuration.MailConfig;
import com.ensapay.bank.entities.MailTempl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {


    Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailConfig mailConfig;
    @Override
    public boolean sendEmail(MailTempl mailTempl, String clientMail) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.mailConfig.getHost());
        mailSender.setPort(this.mailConfig.getPort());
        mailSender.setUsername(this.mailConfig.getUsername());
        mailSender.setPassword(this.mailConfig.getPassword());


        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom("support@ensapay.com");
            mailMessage.setTo(clientMail);
            mailMessage.setSubject(mailTempl.getSubject());
            mailMessage.setText(mailTempl.getMessage());

            mailSender.send(mailMessage);

            logger.info("Email sended to :" + clientMail+ "with subject:"+mailTempl.getSubject());
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
}

