package com.captain.CaptainAmerica.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class InvoiceDTO implements Serializable {

    private Long id;

    private String userId;

    private String price;

    private String productName;

    private String orderId;
}
