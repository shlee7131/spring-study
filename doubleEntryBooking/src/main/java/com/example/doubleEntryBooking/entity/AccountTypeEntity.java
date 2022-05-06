package com.example.doubleEntryBooking.entity;

import com.example.doubleEntryBooking.adapter.db.AccountTypeRepository;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AccountTypeEntity {
    private final AccountTypeRepository repository;
    private final Map<String, AccountType> lookUpTable = new HashMap<>();

    public AccountTypeEntity(AccountTypeRepository accountTypeRepository){
        this.repository = accountTypeRepository;
        setLookUpTable();
    }

    // 생성 시 룩업 테이블 데이터 초기화
    public void setLookUpTable(){
        List<AccountType> list = repository.findAll();
        for(AccountType element : list) {
            lookUpTable.put(element.getCode(), element);
        }
    }

    public AccountType getAccountTypeByCode(String code){
        AccountType accountType = lookUpTable.get(code);
        return accountType;
    }
}
