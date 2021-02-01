package com.ensapay.bank.services.form;


import com.ensapay.bank.soapApi.GetFormClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetFormServiceImpl implements GetFormService {


        @Autowired
        GetFormClient getFormClient;
    @Override
    public List<String> getForm(String creditor_code, long categorie_id) {

        // consuming the soap service here
        //return getFormClient.getForm(creditor_code,categorie_id).getFields;

        return new ArrayList<>();
    }


}
