package com.ensapay.bank.services.payment;


import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public double pay(long account_number, long creditor_code, long amount) {
        return 0;
    }
}
