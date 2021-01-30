package com.ensapay.bank.Security.repository;



import com.ensapay.bank.Security.models.ERole;
import com.ensapay.bank.Security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
