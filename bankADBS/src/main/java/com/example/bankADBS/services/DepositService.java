package com.example.bankADBS.services;

import com.example.bankADBS.domains.Deposit;
import com.example.bankADBS.repository.Depository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepositService {
    @Autowired
    private Depository depository;

    public List<Deposit> getAllDeposits(String accountId) {
        List<Deposit> listOfDeposits = new ArrayList<>();
        depository.findAll().forEach(listOfDeposits::add);
        return listOfDeposits;
    }

    public Optional<Deposit> getDepositById(String depositId) {
        return depository.findById(depositId);
    }

    public void addDeposit(Deposit deposit, long accountId) {
        depository.save(deposit);
    }

    public void updateDeposit(Deposit deposit, String depositId) {
        depository.save(deposit);
    }

    public void deleteDeposit(String depositId) {
        depository.deleteById(depositId);
    }
}
