package com.example.bankADBS.domains;

<<<<<<< HEAD
public class Customer {
=======
import java.util.Set;


public class Customer {
    private long id;
    private String firstName;
    private String lastName;
    private Set<Address> addressSet;





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
>>>>>>> 1449ab2c7746e2a1ab8e5be0218b1ed447cc5f2f
}
