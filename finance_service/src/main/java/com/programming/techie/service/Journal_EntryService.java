package com.programming.techie.service;


import com.programming.techie.dto.ItemDto;
import com.programming.techie.dto.Journal_EntryDto;
import com.programming.techie.model.Item;
import com.programming.techie.model.Journal_Entry;
import com.programming.techie.repository.Journal_EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Journal_EntryService {

    @Autowired
    Journal_EntryRepository journal_entryRepository;

    public List<Journal_EntryDto> all() {

        List<Journal_Entry> journal_entryList = journal_entryRepository.findAll();
        List<Journal_EntryDto> list = new ArrayList();
        for (Journal_Entry journal_entry :
                journal_entryList) {
            Journal_EntryDto dto = new Journal_EntryDto();
            dto.setId(journal_entry.getId());
            dto.setDate(journal_entry.getDate());
            dto.setTransaction(journal_entry.getTransaction());
            dto.setCredit(journal_entry.getCredit());
            dto.setDebit(journal_entry.getDebit());
            list.add(dto);

        }
        return list;
    }
}
