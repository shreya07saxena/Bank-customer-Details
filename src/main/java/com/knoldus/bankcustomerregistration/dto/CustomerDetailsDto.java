package com.knoldus.bankcustomerregistration.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDetailsDto {
    private int customerId;
    private String customerName;
    private int accountNo;
    private double balance;

}
