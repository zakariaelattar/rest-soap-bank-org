package com.ensapay.bank.services.payment;

import com.ensapay.bank.entities.Transaction;

public interface PaymentService {


    public abstract String firstStepPayment(String account_number, String creditor_code, double amount);
    public abstract double secondStepPayment(String transaction, String code);
    public abstract boolean checkVerificationCode(Transaction transaction, String code);
    public abstract boolean sendVerificationCode(String email, String code);

}
