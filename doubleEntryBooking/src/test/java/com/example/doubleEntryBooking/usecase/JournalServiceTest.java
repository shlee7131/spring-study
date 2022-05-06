package com.example.doubleEntryBooking.usecase;

import com.example.doubleEntryBooking.AutoConfig;
import com.example.doubleEntryBooking.adapter.db.AccountTypeMemoryDB;
import com.example.doubleEntryBooking.adapter.db.AccountTypeRepository;
import com.example.doubleEntryBooking.adapter.db.JournalMemoryDB;
import com.example.doubleEntryBooking.adapter.db.JournalRepository;
import com.example.doubleEntryBooking.entity.AccountTypeEntity;
import com.example.doubleEntryBooking.entity.JournalEntity;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class JournalServiceTest {
    JournalInputPort journalInputPort;

    @BeforeEach
    void beforeEach(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        journalInputPort = ac.getBean(JournalInputPort.class);
        AccountTypeMemoryDB bean = ac.getBean(AccountTypeMemoryDB.class);
        bean.addAccountType(new AccountType(1l,"temp",true));
    }

    @Test
    @DisplayName("용돈 내역 추가")
    void addJournal(){
        String userId = "temp";
        User user = new User(userId, "temp");
        JournalVO journalVO = new JournalVO(1000,"temp");

        journalInputPort.addJournal(user, "temp",journalVO);
        List<Journal> allByUserId = journalInputPort.getAllJournalByUser(user);

        assertThat(allByUserId.get(0).getId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("유저의 용돈 내역 모두 확인")
    void getAllJournalByUser(){
        String userId = "temp";
        User user = new User(userId, "temp");
        JournalVO journalVO = new JournalVO(1000,"temp");

        journalInputPort.addJournal(user, "temp",journalVO);
        journalInputPort.addJournal(user, "temp",journalVO);
        journalInputPort.addJournal(user, "temp",journalVO);
        List<Journal> allByUserId = journalInputPort.getAllJournalByUser(user);

        assertThat(allByUserId).hasSize(3);
    }

}