package com.ensapay.bank.services.creditor;

import com.cmi.providedws.wsdl.Creditor;

import java.util.List;

public interface CreditorService {

    public abstract List<Creditor> getCreditors();
}
