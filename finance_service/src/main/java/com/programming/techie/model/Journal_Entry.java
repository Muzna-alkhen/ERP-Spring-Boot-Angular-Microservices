package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "journal_entry")
public class Journal_Entry
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
