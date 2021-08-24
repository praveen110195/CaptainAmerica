package com.captain.CaptainAmerica.dto;

import com.captain.CaptainAmerica.gender.Gender;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@Data
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String firstName;

    private String lastName;

    private String userId;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
