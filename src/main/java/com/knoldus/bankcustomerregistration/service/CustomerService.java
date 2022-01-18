package com.knoldus.bankcustomerregistration.service;

import com.knoldus.bankcustomerregistration.dto.CustomerDetailsDto;
import com.knoldus.bankcustomerregistration.entity.CustomerPersonalDetails;
import com.knoldus.bankcustomerregistration.repository.CustomerDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    CustomerDetailsRepo customerDetailsRepo;
    @Autowired
    ModelMapper modelMapper;

    public int saveCustomerDetails(CustomerDetailsDto dto){
        CustomerPersonalDetails details = dtoToDBmappper(dto);
        details.setAccountNo(generateAccNo());
        customerDetailsRepo.save(details);
       return details.getAccountNo();

    }
    private CustomerPersonalDetails dtoToDBmappper(CustomerDetailsDto dto){
         return modelMapper.map(dto, CustomerPersonalDetails.class);
    }
    private int generateAccNo(){
        Random r = new Random(System.currentTimeMillis());
        return 1000000000 + r.nextInt(2000000000);

    }


    public List<String> getCustomerName(double amount){
        List<String> name=new ArrayList<>();
       List<CustomerPersonalDetails> lista= customerDetailsRepo.findAll();

        List<CustomerPersonalDetails> details = lista.stream().filter(dto->dto.getBalance()<=amount).collect(Collectors.toList());
        for (CustomerPersonalDetails nameLista:details) {
            name.add(nameLista.getCustomerName());
        }
         return name;
    }
}
