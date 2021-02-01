package com.ensapay.bank.entities;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAccountRequest {

    private String client_cin;
    private long product_id;
}
