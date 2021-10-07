package com.programming.techie.controller;


import com.programming.techie.dto.ItemDto;
import com.programming.techie.dto.Journal_EntryDto;
import com.programming.techie.service.Journal_EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/journal-entry")
public class Journal_EntryController {
    @Autowired
    Journal_EntryService journal_entryService;



    @GetMapping("/all")
    public List<Journal_EntryDto> all() {
        return journal_entryService.all();

    }

}
