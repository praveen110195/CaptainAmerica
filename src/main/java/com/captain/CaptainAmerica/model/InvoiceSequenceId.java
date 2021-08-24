package com.captain.CaptainAmerica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invoice_sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceSequenceId {

    @Id
    private String id;

    private long seq;
}
