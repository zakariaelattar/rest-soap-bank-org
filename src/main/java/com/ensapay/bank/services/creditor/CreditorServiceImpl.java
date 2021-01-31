package com.ensapay.bank.services.creditor;


import com.cmi.providedws.wsdl.Creditor;
import com.ensapay.bank.soapApi.CreditorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditorServiceImpl implements CreditorService{
    @Autowired
    CreditorClient creditorClient;

    @Override
    public List<Creditor> getCreditors() {

        // calling here the soap service (getCreditors is the getter of the creditor attribute appropriate to the CreditorResponse)
        return creditorClient.getCreditors().getCreditors();


    }
}
