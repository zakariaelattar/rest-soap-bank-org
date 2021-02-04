package com.ensapay.bank.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FirstWrapperRequest {


    private String account_number;
    private double amount;
    private String creditor_code;
}
