package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Account;
import com.ensapay.bank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
    public abstract Client findFirstById(long client_id);
   public abstract Client findFirstByCin(String cin);

    Client findFirstByAccount(Account account);
}
