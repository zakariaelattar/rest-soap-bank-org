package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    public abstract Account findByAccountNumber(String account_number);
}
