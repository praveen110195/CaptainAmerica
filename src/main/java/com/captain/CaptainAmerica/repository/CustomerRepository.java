package com.captain.CaptainAmerica.repository;

import com.captain.CaptainAmerica.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, Long> {
    Customer findByUserId(String userId);

    void deleteByUserId(String userId);
}
