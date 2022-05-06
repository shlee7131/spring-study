package com.example.doubleEntryBooking.entity.domain;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class Journal implements Comparable<Journal> {
    private final Long id;
    private final AccountType accountType;
    private final int amount;
    private final String memo;
    private final Date date;
    private final User user;

    public Journal(Long id, AccountType accountType, int amount, String memo, Date date, User user) {
        this.id = id;
        this.accountType = accountType;
        this.amount = amount;
        this.memo = memo;
        this.date = date;
        this.user = user;
    }

    @Override
    public int compareTo(Journal o) {
        return this.date.compareTo(o.date);
    }
}
