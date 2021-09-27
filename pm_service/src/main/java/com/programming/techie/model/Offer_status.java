package com.programming.techie.model;

import javax.persistence.*;


@Entity
@Table(name = "quotation_status")
public class Quotation_status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
