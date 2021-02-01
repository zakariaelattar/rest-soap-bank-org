package com.ensapay.bank.services.mail;

import com.ensapay.bank.entities.MailTempl;

public interface MailService {

    public abstract boolean  sendEmail(MailTempl mailTempl, String clientMail);

}
