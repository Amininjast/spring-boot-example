package com.amininjast.customer;

public record CustomerRegisterationRequest(
        String name,
        String email,
        Integer age
) {
}
