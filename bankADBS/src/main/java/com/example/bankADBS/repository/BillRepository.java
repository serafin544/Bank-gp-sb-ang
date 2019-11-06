package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Bills;
import org.springframework.data.repository.CrudRepository;

public interface BillRepository extends CrudRepository<Bills, Long> {
}
