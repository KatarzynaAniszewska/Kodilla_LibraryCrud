package com.crud.kodillalibrary.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter

public class RentalDto {
    private long id;
    private LocalDate dateOfRental;
    private LocalDate dateOfReturn;
    private Long reader_id;
    private Long bookCopy_id;
}
