package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;

import java.util.List;

public interface JournalInputPort {
    void addJournal(User user, String accountCode, JournalVO journalVO);
    List<Journal> getAllJournalByUser(User user);
}
