package com.example.bankADBS.repository;

import com.example.bankADBS.domains.Withdrawal;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WithdrawalRepository extends CrudRepository<Withdrawal, Long> {
}
