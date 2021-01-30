package com.ensapay.bank.restApi;


import com.ensapay.bank.entities.Account;
import com.ensapay.bank.entities.Invoice;
import com.ensapay.bank.services.account.AccountService;
import com.ensapay.bank.services.account.AccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
public class AccountController {

    @Autowired
    AccountService accountService;

    Logger logger = LoggerFactory.getLogger(AccountController.class);

    /**
     *  Enable disable an account
     * */

    @RequestMapping(value = "" , method = RequestMethod.POST)
    public Account openAccount(@RequestBody Account account) {
        logger.info("trying to open a new account :...");
        try {
            return accountService.openAccount(account);

        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }


    }

    @RequestMapping(value = "balance",method = RequestMethod.GET)
    public double checkBalance(@RequestParam(value = "account_number") long account_number)
    {

        return accountService.checkBalance(account_number);


    }




}
