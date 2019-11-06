package com.example.bankADBS.domains;

public class Bills {

  //bill unique identifier
  private Long id;

  //enumerated value showing bill status (pending, cancelled, completed, recurring)
  private String status;

  //place bill will be paid to
  private String payee;

  //nickname of bill to help identify it
  private String nickname;

  //date bill was created
  private String creationDate;

  //date bill is going to be paid or was paid
  private String paymentDate;

  //date bill recurs monthly
  private Integer recurringDate;

  //next bill payment date
  private String upcomingPaymentDate;

  //amount of payment
  private Double paymentAmount;

  //id account will be associated
  private String accountId;



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPayee() {
    return payee;
  }

  public void setPayee(String payee) {
    this.payee = payee;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(String creationDate) {
    this.creationDate = creationDate;
  }

  public String getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Integer getRecurringDate() {
    return recurringDate;
  }

  public void setRecurringDate(Integer recurringDate) {
    this.recurringDate = recurringDate;
  }

  public String getUpcomingPaymentDate() {
    return upcomingPaymentDate;
  }

  public void setUpcomingPaymentDate(String upcomingPaymentDate) {
    this.upcomingPaymentDate = upcomingPaymentDate;
  }

  public Double getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(Double paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "Bills{" +
      "id=" + id +
      ", status='" + status + '\'' +
      ", payee='" + payee + '\'' +
      ", nickname='" + nickname + '\'' +
      ", creationDate='" + creationDate + '\'' +
      ", paymentDate='" + paymentDate + '\'' +
      ", recurringDate=" + recurringDate +
      ", upcomingPaymentDate='" + upcomingPaymentDate + '\'' +
      ", paymentAmount=" + paymentAmount +
      ", accountId='" + accountId + '\'' +
      '}';
  }
}
