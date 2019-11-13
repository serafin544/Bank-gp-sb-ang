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

    public List<Deposit> getAllDepositsForAccount(Long accountId) {
        List<Deposit> listOfDeposits = new ArrayList<>();
        depository.findAll().forEach(listOfDeposits::add);

        List<Deposit> validDeposits = new ArrayList<>();
        for(Deposit d : listOfDeposits){
            if(d.getPayee_id() == accountId)
                validDeposits.add(d);
        }
        return validDeposits;
    }

    public Optional<Deposit> getDepositById(Long depositId) {
        return depository.findById(depositId);
    }

    public Deposit addDeposit(Deposit deposit, Long accountId) { return depository.save(deposit); }

    public Deposit updateDeposit(Deposit deposit, Long depositId) {
        return depository.save(deposit);
    }

    public void deleteDeposit(Long depositId) {
        depository.deleteById(depositId);
    }

    //private static boolean findAccount(Deposit d, Long accountId) { return d.getPayee_id() == id; }
}
