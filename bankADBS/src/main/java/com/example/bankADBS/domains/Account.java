package com.example.bankADBS.domains;


import javax.persistence.*;


import javax.persistence.Entity;
import javax.persistence.Id;
import com.example.bankADBS.domains.Type;

@Entity
public class Account {


    @Id
    @Column(name="ACCOUNT_ID")
    private Long _id;

    @Column(name="TYPE")
    private String type;

    @Column(name="NICKNAME")
    private String nickname;

    @Column(name="REWARDS")
    private int rewards;

    @Column(name="BALANCE")
    private double balance;

    @ManyToOne
    @JoinColumn(name="CUSTOMER_ID")
    private Customer customer;



    public Account() {
    }

    public Account(Long _id, String type, String nickname, int rewards, double balance, Customer customer) {
        this._id = _id;
        this.type = type;
        this.nickname = nickname;
        this.rewards = rewards;
        this.balance = balance;
        this.customer = customer;
    }

    public Long getId() {
        return _id;
    }

    public void setId(Long id) {
        this._id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + _id +
                ", type=" + type +
                ", nickname='" + nickname + '\'' +
                ", rewards=" + rewards +
                ", balance=" + balance +
                ", customer=" + customer +
                '}';
    }
}
