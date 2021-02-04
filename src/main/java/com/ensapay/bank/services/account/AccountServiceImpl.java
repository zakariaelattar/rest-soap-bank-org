package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Client;
import com.ensapay.bank.entities.Account;
import com.ensapay.bank.entities.MailTempl;
import com.ensapay.bank.entities.Transaction;
import com.ensapay.bank.repositories.AccountRepository;
import com.ensapay.bank.repositories.ClientRepository;
import com.ensapay.bank.repositories.ProductRepository;
import com.ensapay.bank.services.mail.MailService;
import com.ensapay.bank.services.mail.MailServiceImpl;
import com.ensapay.bank.services.payment.PaymentServiceImpl;
import com.ensapay.bank.soapApi.CheckBalanceClient;
import com.ensapay.bank.soapApi.CreateAccountClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    CheckBalanceClient checkBalanceClient;

    @Autowired
    CreateAccountClient createAccountClient;

    @Autowired
    MailService mailService;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ClientRepository clientRepository;
    @Override
    public String openAccount(String cin,long product_id) {

            Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

            logger.info("trying requesting cmi:");
        try {
            // calling here the soap service cmi

            String cmi_response = createAccountClient.createAccount(cin,1).getResponse();
            logger.info("cmi responded bu:"+cmi_response);
            if(cmi_response != "9999999") {

                    Account account = new Account();
                    account.setAccountNumber(cmi_response);
                    account.setProduct(productRepository.findFirstById(product_id));
                    account.setClient(clientRepository.findFirstByCin(cin));
                    accountRepository.save(account);

            sendConfimationMail(account.getClient().getEmail(),cmi_response);
            }
                    return cmi_response;

        }

        catch(Exception e) {
        return "expt";

        }
    }

    @Override
    public double checkBalance(String account_number) {

        // calling here the soap service cmi
        return checkBalanceClient.checkBalance(account_number).getAmount();

    }
    @Override

    public boolean activateAccount(String account_number) {

        try {
        Account account = accountRepository.findByAccountNumber(account_number);
        account.setActive(true);
        accountRepository.save(account);
        return true;

        }
        catch (Exception e) {
            return false;
        }
    }

    @Override
    public  boolean sendConfimationMail(String email,String account_number){


        logger.info("sending confimation mail to "+email);

        return mailService
                .sendEmail(
                        new MailTempl("please click the link below to activate your account:"+ " http://localhost:8090/api/account/activate?account_number="+account_number,
                                "account activation"),
                        email);

    }

}
