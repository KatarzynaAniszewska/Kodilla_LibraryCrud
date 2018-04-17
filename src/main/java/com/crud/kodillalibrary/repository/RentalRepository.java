package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Rental;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface RentalRepository extends CrudRepository<Rental,Long> {

    @Override
    Rental save(Rental rental);

    Rental findByBookCopyId(Long id);

    Rental getById(Long ig);



}

