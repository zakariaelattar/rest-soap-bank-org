package com.ensapay.bank.services.payment;

public interface PaymentService {


    public abstract double pay(long account_number, long creditor_code, long amount);
}
