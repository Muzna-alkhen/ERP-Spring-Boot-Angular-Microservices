package com.programming.techie.repository;

import com.programming.techie.model.Journal_Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Journal_EntryRepository  extends JpaRepository<Journal_Entry, Long> {
}
