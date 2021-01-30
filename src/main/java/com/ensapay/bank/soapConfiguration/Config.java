package com.ensapay.bank.soapConfiguration;


import com.ensapay.bank.soapApi.CheckBalanceClient;
import com.ensapay.bank.soapApi.CreateAccountClient;
import com.ensapay.bank.soapApi.CreditorClient;
import com.ensapay.bank.soapApi.PaymentClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("com.cmi.providedws.wsdl");
        return marshaller;
    }

    @Bean
    public CheckBalanceClient checkBalanceClient(Jaxb2Marshaller marshaller) {
        CheckBalanceClient client = new CheckBalanceClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri("http://localhost:8090/service");
        return client;
    }
    @Bean
    public CreateAccountClient createAccountClient(Jaxb2Marshaller marshaller) {
        CreateAccountClient client = new CreateAccountClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri("http://localhost:8090/service");
        return client;
    }
    @Bean
    public PaymentClient paymentClient(Jaxb2Marshaller marshaller) {
        PaymentClient client = new PaymentClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri("http://localhost:8090/service");
        return client;
    }
    @Bean
    public CreditorClient creditorClient(Jaxb2Marshaller marshaller) {
        CreditorClient client = new CreditorClient();
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setDefaultUri("http://localhost:8090/service");
        return client;
    }

}
