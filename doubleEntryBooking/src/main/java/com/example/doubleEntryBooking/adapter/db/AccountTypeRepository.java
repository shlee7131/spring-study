package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.entity.domain.AccountType;

import java.util.List;

public interface AccountTypeRepository {
    List<AccountType> findAll();
    AccountType findById(Long id);
}
