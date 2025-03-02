package com.rahul.journalApp.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collation = "journal_entries")
@Data
public class JournalEntry {
    @Id
    private String id;
    private String title;

    private String content;

    private Date date;


}
