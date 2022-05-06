package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.entity.AccountTypeEntity;
import com.example.doubleEntryBooking.entity.JournalEntity;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class JournalService implements JournalInputPort {
    private final JournalEntity journalEntity;
    private final AccountTypeEntity accountTypeEntity;

    public JournalService(JournalEntity journalEntity, AccountTypeEntity accountTypeEntity){
        this.journalEntity = journalEntity;
        this.accountTypeEntity = accountTypeEntity;
    }

    @Override
    public void addJournal(User user, String accountCode, JournalVO journalVO){
        AccountType accountTypeByCode = accountTypeEntity.getAccountTypeByCode(accountCode);
        journalEntity.addJournal(user, accountTypeByCode, journalVO);
    }

    @Override
    public List<Journal> getAllJournalByUser(User user) {
        List<Journal> allJournalByUser = journalEntity.getAllJournalByUser(user);
        return allJournalByUser;
    }
}
