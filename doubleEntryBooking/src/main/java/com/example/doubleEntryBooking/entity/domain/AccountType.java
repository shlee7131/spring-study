package com.example.doubleEntryBooking.entity.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AccountType {
    private final Long id;
    private final String code;
    private final boolean isDebit;

    public AccountType(Long id, String code, boolean isDebit) {
        this.id = id;
        this.code = code;
        this.isDebit = isDebit;
    }
}
