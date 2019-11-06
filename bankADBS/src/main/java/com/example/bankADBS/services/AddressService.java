package com.example.bankADBS.services;

import com.example.bankADBS.domains.Address;
import com.example.bankADBS.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddresses(){
        List<Address> listOfAddresses = new ArrayList<>();
        addressRepository.findAll().forEach(listOfAddresses::add);

        return listOfAddresses;
    }

    public Optional<Address> getCustomerById(long id){
        return addressRepository.findById(id);
    }

    public void addCustomer(Address address){
        addressRepository.save(address);
    }
    public void updateAddressInfo(Address address){
        addressRepository.save(address);
    }
    public void deleteCustomer( long id ){
        addressRepository.deleteById(id);
    }




}
