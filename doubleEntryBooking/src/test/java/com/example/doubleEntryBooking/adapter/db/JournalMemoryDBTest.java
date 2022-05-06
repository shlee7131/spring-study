package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LOCAL_DATE_TIME;
import static org.junit.jupiter.api.Assertions.*;

class JournalMemoryDBTest {

    JournalMemoryDB journalMemoryDB;

    @BeforeEach
    void beforeEach(){
        journalMemoryDB = new JournalMemoryDB();
    }

    @Test
    @DisplayName("유저의 용돈 내역 모두 확인")
    void getAllJournalByUserId(){
        String userId = "temp";
        User user = new User(userId, "temp");
        AccountType accountType = new AccountType(1L, "temp", true);
        JournalVO journalVO = new JournalVO(1000,"temp");

        journalMemoryDB.addJournal(user, accountType,journalVO);
        journalMemoryDB.addJournal(user, accountType,journalVO);
        journalMemoryDB.addJournal(user, accountType,journalVO);
        List<Journal> allByUserId = journalMemoryDB.findAllByUserId(userId);

        assertThat(allByUserId).hasSize(3);
    }

    @Test
    @DisplayName("유저 용돈 내역 추가")
    void addJournalByUserId(){
        String userId = "temp";
        User user = new User(userId, "temp");
        AccountType accountType = new AccountType(1L, "temp", true);
        JournalVO journalVO = new JournalVO(1000,"temp");

        journalMemoryDB.addJournal(user, accountType,journalVO);
        List<Journal> allByUserId = journalMemoryDB.findAllByUserId(userId);

        assertThat(allByUserId.get(0).getId()).isEqualTo(1L);
    }

}