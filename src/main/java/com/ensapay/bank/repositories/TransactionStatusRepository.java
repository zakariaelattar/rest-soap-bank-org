package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatus,Long> {
    TransactionStatus findByName(String pending);
}
