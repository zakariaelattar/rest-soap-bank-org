package com.ensapay.bank.restApi;


import com.ensapay.bank.entities.Account;
import com.ensapay.bank.entities.Client;
import com.ensapay.bank.entities.CreateAccountRequest;
import com.ensapay.bank.repositories.ClientRepository;
import com.ensapay.bank.services.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
public class AccountApi {

    @Autowired
    AccountService accountService;
    @Autowired
    ClientRepository clientRepository;
    Logger logger = LoggerFactory.getLogger(AccountApi.class);



    @RequestMapping(value = "new",method = RequestMethod.POST)
    public String openAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        logger.info("trying to open a new account :...");
        try {
            return accountService.openAccount(createAccountRequest.getClient_cin(),createAccountRequest.getProduct_id());

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(value = "balance",method = RequestMethod.GET)
    public double checkBalance(@RequestParam(value = "account_number") String account_number)
    {

        return accountService.checkBalance(account_number);


    }




}
