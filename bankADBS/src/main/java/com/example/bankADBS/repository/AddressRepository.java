package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
