package com.example.bankADBS.services;

import com.example.bankADBS.domains.Withdrawal;
import com.example.bankADBS.repository.WithdrawalRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WithdrawalService {

  private WithdrawalRepository withdrawalRepository;

  public List<Withdrawal> getAllWithdrawals(){
    List<Withdrawal> listOfWithdrawals = new ArrayList<>();
    withdrawalRepository.findAll().forEach(listOfWithdrawals::add);
    return listOfWithdrawals;
  }

  public Optional<Withdrawal> getWithdrawalById(String id){
    return withdrawalRepository.findById(id);
  }

  public void addWithdrawal(Withdrawal withdrawal) {
    withdrawalRepository.save(withdrawal);
  }

  public void updateWithdrawal(String id, Withdrawal withdrawal) {
    withdrawalRepository.save(withdrawal);
  }

  public void deleteWithdrawal(String id) {
    withdrawalRepository.deleteById(id);
  }

}
