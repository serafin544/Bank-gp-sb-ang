package com.example.bankADBS.domains;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;

@Entity
public class Customer {

    @Id
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @ElementCollection
    @OneToMany
    @JoinColumn(name="ADDRESS_ID")
    private Set<Address> addressSet;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, Set<Address> addressSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressSet = addressSet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + _id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressSet=" + addressSet +
                '}';
    }
}
