package com.example.doubleEntryBooking.adapter.web;

import com.example.doubleEntryBooking.AutoConfig;
import com.example.doubleEntryBooking.adapter.db.AccountTypeMemoryDB;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class JournalControllerTest {
    JournalController journalController;

    @BeforeEach
    void beforeEach(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);
        journalController = ac.getBean(JournalController.class);
        AccountTypeMemoryDB bean = ac.getBean(AccountTypeMemoryDB.class);
        bean.addAccountType(new AccountType(1L,"temp",true));
        bean.addAccountType(new AccountType(2L,"temp",true));
    }

    @Test
    @DisplayName("유저 용돈 내역 추가")
    void addJournal(){
        String userId = "temp";
        User user = new User(userId, "temp");
        JournalVO journalVO = new JournalVO(1000,"temp");

        String result = journalController.addJournal(user, "temp", journalVO);
        List<Journal> allByUserId = journalController.getAllJournalByUser(user);

        assertThat(allByUserId.get(0).getId()).isEqualTo(1L);
        assertThat(result).isEqualTo("SUCCESS");
    }

    @Test
    @DisplayName("유저의 용돈 내역 모두 확인")
    void getAllJournalByUser(){
        String userId = "temp";
        User user = new User(userId, "temp");
        JournalVO journalVO = new JournalVO(1000,"temp");

        journalController.addJournal(user, "temp",journalVO);
        journalController.addJournal(user, "temp",journalVO);
        journalController.addJournal(user, "temp",journalVO);
        List<Journal> allByUserId = journalController.getAllJournalByUser(user);

        assertThat(allByUserId).hasSize(3);
    }
}