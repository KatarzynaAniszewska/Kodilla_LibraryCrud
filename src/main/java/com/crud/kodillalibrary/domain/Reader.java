package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "READERS")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "NAME")
    @NotNull
    private String name;
    @Column(name = "SURNAME" )
    @NotNull
    private String surname;
    @Column(name = "MEMBERSHIP_BEGINNING_DATE")
    @NotNull
    private LocalDate dateOfStartingMembership;
}
