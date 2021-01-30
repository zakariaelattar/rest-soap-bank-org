package com.ensapay.bank.soapApi;

import com.cmi.providedws.wsdl.GetCreditorsRequest;
import com.cmi.providedws.wsdl.GetCreditorsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CreditorClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CreditorClient.class);

    public GetCreditorsResponse getCreditors() {

        GetCreditorsRequest getCreditorsRequest = new GetCreditorsRequest();

        log.info("Requesting the cmi web service for creditor list");

        GetCreditorsResponse getCreditorsResponse = (GetCreditorsResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8085/service/creditorsList",getCreditorsRequest,new SoapActionCallback(""));
        log.info("received response from the cmi web service creditors list:"+getCreditorsResponse.getCreditors());



    return getCreditorsResponse;
    }

}
