package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends JpaRepository<Transaction,Long> {

    public abstract Transaction findFirstByTransactionCode(String transaction_code);

    Transaction findTransactionByConfirmationCode(String code);
}
