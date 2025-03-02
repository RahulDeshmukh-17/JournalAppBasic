package com.rahul.journalApp.repository;

import com.rahul.journalApp.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface JournalEntryRepository extends MongoRepository<JournalEntry,String> {
}
