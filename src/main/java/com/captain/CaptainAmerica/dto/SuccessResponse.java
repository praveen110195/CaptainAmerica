package com.captain.CaptainAmerica.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SuccessResponse implements Serializable {

    private static final Long serialVersionUID = 1L;

    private final String message;
}
