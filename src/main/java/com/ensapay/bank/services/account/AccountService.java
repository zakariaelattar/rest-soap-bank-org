package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Account;
import com.ensapay.bank.entities.Transaction;

public interface AccountService {

    public abstract String openAccount(String cin,long product_id);
    public abstract double checkBalance(String account_number);
    public abstract boolean sendConfimationMail(String email,String account_number);
    public abstract boolean activateAccount(String account_number);
}
