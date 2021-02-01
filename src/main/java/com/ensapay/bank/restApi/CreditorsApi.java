package com.ensapay.bank.restApi;


import com.cmi.providedws.wsdl.Creditor;
import com.ensapay.bank.services.account.AccountService;
import com.ensapay.bank.services.creditor.CreditorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/creditors")
public class CreditorsApi {


    @Autowired
    CreditorService creditorService;

    Logger logger = LoggerFactory.getLogger(CreditorsApi.class);

    /**
     *  Enable disable an account
     * */

    @RequestMapping(value = "all",method = RequestMethod.GET)
    public List<Creditor> getCreditors()
    {

        return creditorService.getCreditors();


    }

}
