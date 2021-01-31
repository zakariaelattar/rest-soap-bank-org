package com.ensapay.bank.soapApi;

import com.cmi.providedws.wsdl.CheckBalanceRequest;
import com.cmi.providedws.wsdl.CheckBalanceResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CheckBalanceClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CheckBalanceClient.class);

    public CheckBalanceResponse checkBalance(String account_number) {
    CheckBalanceRequest checkBalanceRequest = new CheckBalanceRequest();
    checkBalanceRequest.setAccountNumber(account_number);

    log.info("Requesting the cmi web service check balance for account:"+account_number);

    CheckBalanceResponse checkBalanceResponse = (CheckBalanceResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8084/service/checkBalance",checkBalanceRequest,new SoapActionCallback(""));
        log.info("received response from the cmi web service check balance for account:"+account_number+":"+checkBalanceResponse.getAmount());


        return checkBalanceResponse;
    }

}
