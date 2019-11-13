package com.example.bankADBS.domains;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "CUSTOMER_TABLE")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CUSTOMER_ID")
    private Long id;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @Size(min = 1, max = 10)
    @OrderBy
    private Set<Address> address;

    public Customer() {
    }

    public Customer(Long id, String firstName, String lastName, Set<Address> address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public Set<Address> getAddress() {
        return address;
    }

    public void setAddress(Set<Address> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addressSet=" + address +
                '}';
    }
}
