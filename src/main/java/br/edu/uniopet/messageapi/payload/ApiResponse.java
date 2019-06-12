package br.edu.uniopet.messageapi.payload;

import lombok.Data;

@Data
public class ApiResponse {
    private final Integer code;
    private final String message;
}