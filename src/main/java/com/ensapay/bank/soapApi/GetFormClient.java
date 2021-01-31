package com.ensapay.bank.soapApi;

import com.cmi.providedws.wsdl.CreateAccountValidationResponse;
import com.cmi.providedws.wsdl.GetFormRequest;
import com.cmi.providedws.wsdl.GetFormResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class GetFormClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(GetFormClient.class);

public GetFormResponse getForm(String creditor_code, long categorie_id) {

    GetFormRequest getFormRequest = new GetFormRequest();


    log.info("Requesting the cmi web service getform for a form categorie:"+categorie_id+", and creditor: "+creditor_code);

    GetFormResponse getFormResponse = (GetFormResponse) getWebServiceTemplate()
            .marshalSendAndReceive("http://localhost:8086/service/getForm",getFormRequest,new SoapActionCallback(""));
    log.info("received response from the cmi web service getForm :"+getFormResponse);


    return getFormResponse;

}

}
