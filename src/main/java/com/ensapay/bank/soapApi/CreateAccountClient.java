package com.ensapay.bank.soapApi;

import com.cmi.providedws.wsdl.CreateAccountValidationRequest;
import com.cmi.providedws.wsdl.CreateAccountValidationResponse;
import com.ensapay.bank.entities.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CreateAccountClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CreateAccountClient.class);

    public CreateAccountValidationResponse createAccount(String cin, long bank_id) {
        log.info("starting process of createAccountClient");
        CreateAccountValidationRequest createAccountValidationRequest = new CreateAccountValidationRequest();
        createAccountValidationRequest.setBankId(bank_id);

        createAccountValidationRequest.setCin(cin);


        log.info("Requesting the cmi web service creation  account for client cin:"+cin);

        CreateAccountValidationResponse createAccountValidationResponse = (CreateAccountValidationResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8083/service/createAccount",createAccountValidationRequest,new SoapActionCallback(""));
        log.info("received response from the cmi web service create payment account validation: "+createAccountValidationResponse.getResponse());




        return createAccountValidationResponse;
    }
}
