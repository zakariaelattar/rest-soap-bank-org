package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
