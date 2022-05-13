package com.example.doubleEntryBooking.adapter.db.repository;

import com.example.doubleEntryBooking.entity.domain.AccountType;

import java.util.List;

public interface AccountTypeRepository {
    List<AccountType> findAll();
    AccountType findById(Long id);
}
