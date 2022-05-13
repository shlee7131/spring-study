package com.example.doubleEntryBooking.adapter.db;

import com.example.doubleEntryBooking.adapter.db.repository.JournalRepository;
import com.example.doubleEntryBooking.entity.domain.AccountType;
import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalVO;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class JournalMemoryDB implements JournalRepository {
    private final Map<Long, Journal> map = new TreeMap<>();
    private final Map<String, PriorityQueue<Journal>> mapIndexedByUser = new HashMap<>();

    @Override
    public List<Journal> findAllByUserId(String userId) {
        ArrayList<Journal> list = new ArrayList<>();
        PriorityQueue<Journal> journals = mapIndexedByUser.get(userId);
        Object[] objects = journals.toArray();
        for(Object obj : objects) {
            list.add((Journal) obj);
        }
        return list;
    }

    @Override
    public void addJournal(User user, AccountType accountType, JournalVO journalVO) {
        Long lastId = Long.valueOf(map.size());
        java.sql.Date date = Date.valueOf(LocalDateTime.now().toLocalDate());
        Journal journal = new Journal(lastId+1, accountType, journalVO.getAmount(), journalVO.getMemo(), date, user);

        map.put(journal.getId(), journal);
        addJournalWithUserIndex(journal);
    }

    public void addJournalWithUserIndex(Journal journal){
        String userId = journal.getUser().getId();
        PriorityQueue<Journal> journals = mapIndexedByUser.get(userId);

        if (journals == null) {
            journals = new PriorityQueue<>();
            journals.add(journal);
            mapIndexedByUser.put(userId, journals);
        } else {
            journals.add(journal);
        }
    }


    public int getSize(){
        return mapIndexedByUser.size();
    }


}
