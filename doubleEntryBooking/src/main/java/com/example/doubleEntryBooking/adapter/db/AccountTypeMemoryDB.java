package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.adapter.db.repository.AccountTypeRepository;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Repository
public class AccountTypeMemoryDB implements AccountTypeRepository {
    private final Map<Long, AccountType> map = new HashMap<>();

    @Override
    public List<AccountType> findAll() {
        ArrayList<AccountType> list = new ArrayList<>();
        for(Entry entry : map.entrySet()) {
            list.add( (AccountType) entry.getValue());
        }
        return list;
    }

    @Override
    public AccountType findById(Long id) {
        return map.get(id);
    }

    // 테스트 코드용 메소드(실제 로직에 사용X)
    public void addAccountType(AccountType accountType){
        map.put(accountType.getId(), accountType);
    }
}
