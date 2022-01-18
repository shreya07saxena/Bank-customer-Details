package com.knoldus.bankcustomerregistration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CustomersPersonalDetails")
public class CustomerPersonalDetails {
@Id

    private int accountNo;
    private int customerId;
    private String customerName;
    private double balance;
}
