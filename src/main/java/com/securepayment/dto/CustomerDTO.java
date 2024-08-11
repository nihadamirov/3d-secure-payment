package com.securepayment.dto;

public record CustomerDTO(
        Long id,
        String firstname,
        String lastname,
        String email,
        String phone

) {

}
