package com.example.bankADBS.services;

import com.example.bankADBS.domains.Withdrawal;
import com.example.bankADBS.repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class WithdrawalService {

  @Autowired
  private WithdrawalRepository withdrawalRepository;


  //get all withdrawals for a specific account
  public List<Withdrawal> getAllWithdrawals(){
    List<Withdrawal> listOfWithdrawals = new ArrayList<>();
    withdrawalRepository.findAll().forEach(listOfWithdrawals::add);
    return listOfWithdrawals;
  }

  //get withdrawal by id
  public Optional<Withdrawal> getWithdrawalById(long id){
    return withdrawalRepository.findById(id);
  }

  //create a withdrawal
  public void addWithdrawal(Withdrawal withdrawal) {
    withdrawalRepository.save(withdrawal);
  }

  //update a specific existing withdrawal
  public void updateWithdrawal(long id, Withdrawal withdrawal) {
    withdrawalRepository.save(withdrawal);
  }

  //delete a specific existing withdrawal
  public void deleteWithdrawal(long id) {
    withdrawalRepository.deleteById(id);
  }

}
