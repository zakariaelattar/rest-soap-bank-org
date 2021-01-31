package com.ensapay.bank.repositories;


import com.ensapay.bank.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    public abstract Product findFirstById(long product_id);
}
