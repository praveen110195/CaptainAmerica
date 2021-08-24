package com.captain.CaptainAmerica.model;

import com.captain.CaptainAmerica.gender.Gender;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Document(collection = "customer")
@Data
public class Customer implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_id")
    private String userId;

    @Column(name="gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
