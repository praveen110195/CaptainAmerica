package com.captain.CaptainAmerica.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@Document(collection="invoice")
public class Invoice implements Serializable {

    @Id
    private Long id;

    @Column(name="userId")
    private String userId;

    @Column(name="price")
    private String price;

    @Column(name="product_name")
    private String productName;

    @Column(name="order_id")
    private String orderId;

}
