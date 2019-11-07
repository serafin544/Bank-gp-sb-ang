package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Bills;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BillRepository extends CrudRepository<Bills, Long> {
    List<Bills> findAccountById(long accountId);
}
