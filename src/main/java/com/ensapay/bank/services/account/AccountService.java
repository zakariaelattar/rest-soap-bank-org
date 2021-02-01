package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Account;

public interface AccountService {

    public abstract String openAccount(String cin,long product_id);
    public abstract double checkBalance(String account_number);
}
