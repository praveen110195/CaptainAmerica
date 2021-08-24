package com.captain.CaptainAmerica.exception;

import lombok.Data;

@Data
public class ProgramException extends RuntimeException{

    private final String message;
}
