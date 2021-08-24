package com.captain.CaptainAmerica.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sequence")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SequenceId {

    @Id
    private String id;

    private long seq;
}