package com.example.bankADBS.domains;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {


    //Different id from Customer and Address
    @Id
    private long id;
    private Enum type;
    private String nickname;
    private int rewards;
    private double balance;
    private Customer customer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Enum getType() {
        return type;
    }

    public void setType(Enum type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }



}
