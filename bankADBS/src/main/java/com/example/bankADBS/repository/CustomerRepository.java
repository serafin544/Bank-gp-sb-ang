package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
