package com.example.bankADBS.domains;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue
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

    public Customer(long id, String firstName, String lastName, Set<Address> addressSet) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressSet = addressSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
