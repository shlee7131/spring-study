package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.entity.domain.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AccountTypeMemoryDBTest {

    public Map<Long, AccountType> map;
    AccountTypeMemoryDB memoryDB;

    @BeforeEach
    void beforeEach(){
        memoryDB = new AccountTypeMemoryDB();
        memoryDB.addAccountType(new AccountType(1L,"1",true));
        memoryDB.addAccountType(new AccountType(2L,"2",true));
    }

    @Test
    @DisplayName("계정과목 전부 찾기")
    void findAll() {
        List<AccountType> all = memoryDB.findAll();
        assertThat(all).hasSize(2);
    }

    @Test
    @DisplayName("계정과목 아이디로 조회")
    void findById() {
        AccountType accountType = new AccountType(1L,"1",true);
        AccountType byId = memoryDB.findById(1L);
        assertThat(byId.toString()).isEqualTo(accountType.toString());
    }

    @Test
    @DisplayName("계정과목 아이디로 조회 실패")
    void findByIdFail() {
        AccountType byId = memoryDB.findById(3L);
        assertThat(byId).isNull();
    }
}