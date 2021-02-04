package com.ensapay.bank.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Account account;

    private String transactionCode;
    private LocalDateTime created_at;
    private String confirmationCode;
    private double amount;

    @ManyToOne
    private TransactionStatus status;



}
