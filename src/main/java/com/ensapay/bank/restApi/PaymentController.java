package com.ensapay.bank.restApi;

import com.ensapay.bank.services.payment.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {


    @Autowired
    PaymentService paymentService;
    Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @RequestMapping(value = "pay" , method = RequestMethod.POST)
    public int pay(@RequestBody long account_number, @RequestBody long creditor_code, @RequestBody long amount) {
        logger.info("trying to paying the amount: "+amount+", to creditor: "+creditor_code+"from account: "+account_number);
        paymentService.pay(account_number,creditor_code,amount);
        return 55;

    }

}
