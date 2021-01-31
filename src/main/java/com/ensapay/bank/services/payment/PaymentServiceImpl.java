package com.ensapay.bank.services.payment;


import com.ensapay.bank.soapApi.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PaymentServiceImpl implements PaymentService {


    @Autowired
    PaymentClient paymentClient;
    @Override
    public double pay(long account_number, long creditor_code, long amount) {
        return 	paymentClient.pay(123456789,1,20).getResponse();

    }
}
