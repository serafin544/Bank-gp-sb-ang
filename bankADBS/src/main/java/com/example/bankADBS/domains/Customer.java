package com.example.bankADBS.domains;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.Set;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    @Column(name="CUSTOMER_ID")
    private Long _id;

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

    public Customer(Long _id, String firstName, String lastName, Set<Address> addressSet) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressSet = addressSet;
    }


    public Long getId() {
        return _id;
    }

    public void setId(Long _id) {
        this._id = _id;
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
