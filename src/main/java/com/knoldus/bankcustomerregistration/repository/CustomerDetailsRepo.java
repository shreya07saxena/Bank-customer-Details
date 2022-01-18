package com.knoldus.bankcustomerregistration.repository;

import com.knoldus.bankcustomerregistration.entity.CustomerPersonalDetails;
import com.mongodb.Mongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDetailsRepo extends MongoRepository<CustomerPersonalDetails, Integer> {
}
