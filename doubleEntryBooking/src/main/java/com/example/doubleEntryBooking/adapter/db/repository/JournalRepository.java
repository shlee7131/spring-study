package com.example.doubleEntryBooking.adapter.db.repository;

import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalVO;

import java.util.List;

public interface JournalRepository {
    List<Journal> findAllByUserId(String userId);
    void addJournal(User user, AccountType accountType, JournalVO JournalVO);
}
