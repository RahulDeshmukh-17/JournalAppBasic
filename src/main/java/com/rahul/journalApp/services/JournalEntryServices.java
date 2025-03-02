package com.rahul.journalApp.services;

import com.rahul.journalApp.entity.JournalEntry;
import com.rahul.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Component
public class JournalEntryServices {
    @Autowired
    private JournalEntryRepository journalentryrepository;

    public void saveEntry(JournalEntry journalEntry){
        journalentryrepository.save(journalEntry);
    }
    public List<JournalEntry> getAll(){
        return journalentryrepository.findAll();
    }
    public Optional<JournalEntry> findbyId(String id){
        return journalentryrepository.findById(id);
    }
    public void deleteById(String id){
        journalentryrepository.deleteAllById(Collections.singleton(id));
    }
}
