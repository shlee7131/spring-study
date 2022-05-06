package com.example.doubleEntryBooking.usecase;

import lombok.Getter;

@Getter
public class JournalVO {
    private final int amount;
    private final String memo;

    public JournalVO(int amount, String memo) {
        this.amount = amount;
        this.memo = memo;
    }
}
