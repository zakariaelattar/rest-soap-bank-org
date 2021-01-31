package com.ensapay.bank.services.account;


import com.ensapay.bank.entities.Client;
import com.ensapay.bank.entities.Account;
import com.ensapay.bank.repositories.AccountRepository;
import com.ensapay.bank.repositories.ClientRepository;
import com.ensapay.bank.repositories.ProductRepository;
import com.ensapay.bank.soapApi.CheckBalanceClient;
import com.ensapay.bank.soapApi.CreateAccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    CheckBalanceClient checkBalanceClient;
    @Autowired
    CreateAccountClient createAccountClient;

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ClientRepository clientRepository;
    @Override
    public String openAccount(long client_id,long product_id) {

        Client client = clientRepository.findFirstById(client_id);

        try {
            // calling here the soap service cmi
            String cmi_response = createAccountClient.createAccount(client,1).isResponse();

            if(cmi_response != "9999999") {

                    Account account = new Account();
                    account.setAccountNumber(cmi_response);
                    account.setProduct(productRepository.findFirstById(product_id));
                    accountRepository.save(account);

            }
                    return cmi_response;

        }

        catch(Exception e) {
        return "expt";

        }
    }

    @Override
    public double checkBalance(String account_number) {

        // calling here the soap service cmi
        return checkBalanceClient.checkBalance(account_number).getAmount();

    }
}
