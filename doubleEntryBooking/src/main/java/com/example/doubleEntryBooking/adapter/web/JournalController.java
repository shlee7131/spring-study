package com.example.doubleEntryBooking.adapter.web;

import com.example.doubleEntryBooking.entity.domain.Journal;
import com.example.doubleEntryBooking.entity.domain.User;
import com.example.doubleEntryBooking.usecase.JournalInputPort;
import com.example.doubleEntryBooking.usecase.JournalVO;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class JournalController {
    private final JournalInputPort inputPort;

    public JournalController(JournalInputPort inputPort){
        this.inputPort = inputPort;
    }

    public String addJournal(User user, String accountCode, JournalVO journalVO){
        inputPort.addJournal(user, accountCode, journalVO);
        return "SUCCESS";
    }

    public List<Journal> getAllJournalByUser(User user){
        return inputPort.getAllJournalByUser(user);
    }
}
