package com.knoldus.bankcustomerregistration.controller;

import com.knoldus.bankcustomerregistration.dto.CustomerDetailsDto;
import com.knoldus.bankcustomerregistration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/BankCustomerDetails")
public class CustomerDetailsController {


    @Autowired
    CustomerService service;
    @PostMapping("/save")
    public String saveCustomerDetails(@RequestBody CustomerDetailsDto details){
         int accNo= service.saveCustomerDetails(details);

         return "Customer details are successfully saved into database with account no." +accNo;

    }
    @GetMapping("/getCustomerName/{amount}")
    public List<String> getCustomerName(@PathVariable double amount){

        List<String> name=service.getCustomerName(amount);
return name;

    }
}
