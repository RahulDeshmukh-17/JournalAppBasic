package com.rahul.journalApp.controller;

import com.rahul.journalApp.entity.JournalEntry;
import com.rahul.journalApp.services.JournalEntryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    @Autowired
    private JournalEntryServices journalEntryServices;

    @GetMapping
    public List<JournalEntry> getAl(){
        return journalEntryServices.getAll();
    }

    @PostMapping
    public boolean createentries(@RequestBody JournalEntry myentry){
        journalEntryServices.saveEntry(myentry);
        return true;
    }

    @GetMapping("/{myid}")
    public ResponseEntity<?> getbyid(@PathVariable String myid){
        Optional<JournalEntry> journalEntry=journalEntryServices.findbyId(myid);
        return journalEntry.<ResponseEntity<?>>map(entry -> new ResponseEntity<>(entry, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(journalEntry.get(), HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{myid}")
    public ResponseEntity<?> removebyid(@PathVariable String myid){
        journalEntryServices.deleteById(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping ("/{myid}")
    public ResponseEntity<?> updatebyid(@PathVariable String myid,@RequestBody JournalEntry newEntry){
        JournalEntry old=journalEntryServices.findbyId(myid).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle() != null && newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
            old.setTitle(newEntry.getContent() != null && newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
            journalEntryServices.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
