package com.ensapay.bank;

import com.ensapay.bank.soapApi.CheckBalanceClient;
import com.ensapay.bank.soapApi.CreateAccountClient;
import com.ensapay.bank.soapApi.CreditorClient;
import com.ensapay.bank.soapApi.PaymentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {

	@Autowired
	CheckBalanceClient checkBalanceClient;
	@Autowired
	CreateAccountClient createAccountClient;
	@Autowired
	PaymentClient paymentClient;

	@Autowired
	CreditorClient creditorClient;


	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//checkBalanceClient.checkBalance(123456789);
		/*Client client = new Client();

		client.setCin("ee123456");
		client.setFirst_name("zakaria");
		client.setLast_name("el attar");

		createAccountClient.createAccount(client,1);*/

		//paymentClient.pay(123456789,1,20);

		creditorClient.getCreditors();
	}
}