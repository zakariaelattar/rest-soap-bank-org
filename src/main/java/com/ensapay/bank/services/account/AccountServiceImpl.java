package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Account;
import com.ensapay.bank.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    AccountRepository accountRepository;
    @Override
    public Account openAccount(Account account) {

        try {

            if(requestAccountCreationValidationCMI(account)) {
                accountRepository.save(account);
            }

            return account;
        }

        catch(Exception e) {
        return null;

        }
    }

    @Override
    public boolean requestAccountCreationValidationCMI(Account account) {
        /**
         * SEND AN XML MESSAGE TO WEB SERVICE CMI VALIDATION
         */

        return false;
    }

    @Override
    public double checkBalance(long account_number) {
        return 0;
    }
}
