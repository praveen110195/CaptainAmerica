package com.captain.CaptainAmerica.repository;

import com.captain.CaptainAmerica.model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice, Long> {
    Invoice findByOrderId(String orderId);

    void deleteByOrderId(String orderId);
}
