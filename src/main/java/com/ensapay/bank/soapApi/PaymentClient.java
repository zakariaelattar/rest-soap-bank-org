package com.ensapay.bank.soapApi;

import com.cmi.providedws.wsdl.PaymentRequest;
import com.cmi.providedws.wsdl.PaymentResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class PaymentClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(PaymentClient.class);

    public PaymentResponse pay(long account_number,long creditor_id,double amount) {

        PaymentRequest paymentRequest = new PaymentRequest();

        paymentRequest.setAccountNumber(account_number);
        paymentRequest.setCreditorId(creditor_id);
        paymentRequest.setAmount(amount);

        log.info("Requesting the cmi web service payment to pay for creditor with id:"+creditor_id+",the amount:"+amount+", from account:"+account_number);

        PaymentResponse paymentResponse = (PaymentResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8089/service/payment",paymentRequest,new SoapActionCallback(""));
        log.info("received response from the cmi web service payment that the balance is:"+paymentResponse.getResponse());





        return paymentResponse;
    }
}
