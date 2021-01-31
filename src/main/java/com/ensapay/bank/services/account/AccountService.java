package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Account;

public interface AccountService {

    public abstract String openAccount(long client_id,long product_id);
    public abstract double checkBalance(String account_number);
}
