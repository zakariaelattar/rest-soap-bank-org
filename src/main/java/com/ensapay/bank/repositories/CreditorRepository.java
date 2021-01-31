package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Creditor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CreditorRepository extends JpaRepository<Creditor,Long> {
}
