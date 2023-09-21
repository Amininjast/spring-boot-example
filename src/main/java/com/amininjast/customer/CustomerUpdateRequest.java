package com.amininjast.customer;

public record CustomerUpdateRequest(
        String name,
        String email,
        Integer age
) {
}
