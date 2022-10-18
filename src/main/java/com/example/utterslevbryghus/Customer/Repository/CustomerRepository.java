package com.example.utterslevbryghus.Customer.Repository;

import com.example.utterslevbryghus.Customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
