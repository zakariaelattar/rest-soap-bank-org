package com.ensapay.bank.services.form;


import java.util.List;

public interface GetFormService {

    public List<String> getForm(String creditor_id,long categorie_id);
}
