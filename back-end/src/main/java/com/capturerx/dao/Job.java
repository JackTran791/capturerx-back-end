package com.capturerx.dao;

import com.capturerx.enumeration.Status;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;
}
