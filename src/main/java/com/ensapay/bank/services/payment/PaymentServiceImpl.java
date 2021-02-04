package com.ensapay.bank.services.payment;


import com.ensapay.bank.entities.*;
import com.ensapay.bank.repositories.AccountRepository;
import com.ensapay.bank.repositories.ClientRepository;
import com.ensapay.bank.repositories.TransactionRepository;
import com.ensapay.bank.repositories.TransactionStatusRepository;
import com.ensapay.bank.restApi.PaymentApi;
import com.ensapay.bank.services.mail.MailService;
import com.ensapay.bank.soapApi.PaymentClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;


@Service
public class PaymentServiceImpl implements PaymentService {

    Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    PaymentClient paymentClient;
    @Autowired
    MailService mailService;
    @Autowired
    TransactionRepository transactionRepository;


    @Autowired
    TransactionStatusRepository transactionStatusRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired

    ClientRepository clientRepository;


    @Override
    public String firstStepPayment(String account_number, String creditor_code, double amount) {

        logger.info("first step function");
        try {
            Account account = accountRepository.findByAccountNumber(account_number);
            Client client = account.getClient();
            logger.info("client is:"+client.getEmail());

            // generating 4 digits secret code

            String code = String.format("%04d",new Random().nextInt(10000));

            String transaction_code = generateTransactionCode(account_number);
            // create transaction with status pending
            Transaction transaction = new Transaction();

            transaction.setAccount(account);
            transaction.setTransactionCode(transaction_code);
            transaction.setConfirmationCode(code);
            transaction.setCreated_at(LocalDateTime.now());
            transaction.setStatus(transactionStatusRepository.findByName("pending"));

            transactionRepository.save(transaction);
            logger.info("transaction saved");
            sendVerificationCode(client.getEmail(),code);
            return transaction_code;

        }
        catch (Exception e) {
            return "error occured";

        }


    }


    public double secondStepPayment(String transaction_code,String code) {

        logger.info("trying to make seconde step service for transaction code:"+transaction_code);
        Transaction transaction = transactionRepository.findTransactionByConfirmationCode(code);
        logger.info("transaction code:"+transaction.getTransactionCode());
        if(!checkVerificationCode(transaction,code)) {
            transaction.setStatus(transactionStatusRepository.findByName("canceled"));

            return -999999;
        }
        transaction.setStatus(transactionStatusRepository.findByName("succeeded"));
        transactionRepository.save(transaction);
        return 	paymentClient
                .pay(
                transaction.getAccount().getAccountNumber(),
                1,
                transaction.getAmount()).getResponse();

    }
    @Override
    public boolean sendVerificationCode(String email, String code) {

        logger.info("sending verification code :"+code+" to "+email);

        return mailService
                .sendEmail(
                        new MailTempl("Your verification code : "+code,"account verification"),
                        email);

    }

    @Override
    public boolean checkVerificationCode(Transaction transaction,String code) {
        logger.info("checkVerificationCode function");

        if(transaction.getConfirmationCode().equals(code)) return true;
        return false;
    }

    public String generateTransactionCode(String account_number)
    {
        return account_number+"_"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }




}
