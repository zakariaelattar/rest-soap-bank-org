package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Account;

public interface AccountService {

    public abstract Account openAccount(Account account);
    public abstract boolean requestAccountCreationValidationCMI(Account account);
    public abstract double checkBalance(long account_number);
    public abstract double pay(long account_number, long creditor_code, long amount);
}
