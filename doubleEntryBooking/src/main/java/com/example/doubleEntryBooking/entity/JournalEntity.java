package com.example.doubleEntryBooking.entity;

import com.example.doubleEntryBooking.adapter.db.repository.JournalRepository;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalVO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntity {
    private final JournalRepository repository;

    public JournalEntity(JournalRepository repository) {
        this.repository = repository;
    }

    public void addJournal(User user, AccountType accountType, JournalVO journalVO){
        repository.addJournal(user, accountType, journalVO);
    }

    public List<Journal> getAllJournalByUser(User user){
        String userId = user.getId();
        List<Journal> allByUserId = repository.findAllByUserId(userId);
        return allByUserId;
    }
}
