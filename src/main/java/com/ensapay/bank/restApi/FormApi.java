package com.ensapay.bank.restApi;


import com.ensapay.bank.services.form.GetFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/getForm")

public class FormApi {


    @Autowired
    GetFormService getFormService;
    @RequestMapping(value = "" , method = RequestMethod.POST)
    public List<String> getForm(@RequestBody  String creditor_code, @RequestBody long categorie_id) {

        return getFormService.getForm(creditor_code,categorie_id);
    }
}
