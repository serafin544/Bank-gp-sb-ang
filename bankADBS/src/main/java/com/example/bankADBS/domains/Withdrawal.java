package com.example.bankADBS.domains;

public class Withdrawal {

  //unique identifier for withdrawal
  private Long id;

  //type of transaction (pending, cancelled, completed)
  private String type;

  //timestamp of deposit execution
  private String transactionDate;

  //status of withdrawal (pending, cancelled, completed)
  private String status;

  //id of account executing withdrawal
  private Long payerId;

  //type of withdrawal (balance, rewards)
  private String medium;

  //withdrawal amount
  private Double amount;

  //description of withdrawal
  private String description;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(String transactionDate) {
    this.transactionDate = transactionDate;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public Long getPayerId() {
    return payerId;
  }

  public void setPayerId(Long payerId) {
    this.payerId = payerId;
  }

  public String getMedium() {
    return medium;
  }

  public void setMedium(String medium) {
    this.medium = medium;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "Withdrawal{" +
      "id=" + id +
      ", type='" + type + '\'' +
      ", transactionDate='" + transactionDate + '\'' +
      ", status='" + status + '\'' +
      ", payerId=" + payerId +
      ", medium='" + medium + '\'' +
      ", amount=" + amount +
      ", description='" + description + '\'' +
      '}';
  }
}
