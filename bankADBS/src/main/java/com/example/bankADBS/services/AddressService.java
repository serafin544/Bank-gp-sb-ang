package com.example.bankADBS.services;

import com.example.bankADBS.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
}
