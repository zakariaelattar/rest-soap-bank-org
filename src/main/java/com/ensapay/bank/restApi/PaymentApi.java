package com.ensapay.bank.restApi;

import com.ensapay.bank.entities.FirstWrapperRequest;
import com.ensapay.bank.entities.SecondWrapperRequest;
import com.ensapay.bank.services.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/payment")

public class PaymentApi {


    @Autowired
    PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(PaymentApi.class);

    @RequestMapping(value = "firstStepPayment" , method = RequestMethod.POST)

    public String firstStepPayment(@RequestBody FirstWrapperRequest firstWrapperRequest) {
       double amount =  firstWrapperRequest.getAmount();
        String creditor_code = firstWrapperRequest.getCreditor_code();
        String account_number = firstWrapperRequest.getAccount_number();

        logger.info(
                "trying to confirm payment the amount: "
                +amount+", to creditor: "
                        +creditor_code+"from account: "
                        +account_number);
        return paymentService.firstStepPayment(account_number,creditor_code,amount);

    }
    @RequestMapping(value = "secondStepPayment" , method = RequestMethod.POST)

    public double secondStepPayment(@RequestBody SecondWrapperRequest secondWrapperRequest) {
        String transaction_code =  secondWrapperRequest.getTransactionCode();
        String code = secondWrapperRequest.getCode();

        logger.info(
                "trying to change transaction status of: "+transaction_code
                       );
        return paymentService.secondStepPayment(transaction_code,code);

    }

}
