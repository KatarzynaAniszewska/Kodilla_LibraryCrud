package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.*;

import com.crud.kodillalibrary.mapper.LibraryMapper;

import com.crud.kodillalibrary.service.DbService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/library")

public class LibraryControler {

    @Autowired
    DbService service;
    @Autowired
    LibraryMapper libraryMapper;


    @RequestMapping(method = RequestMethod.POST, value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        service.saveReader(libraryMapper.mapToReader(readerDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = APPLICATION_JSON_VALUE)
    public void createTitle(@RequestBody TitleDto titleDto) {
        service.saveTitle(libraryMapper.mapToTitle(titleDto));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createBookCopy", consumes = APPLICATION_JSON_VALUE)
    public void createBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        service.saveBookCopy(libraryMapper.mapToBookCopy(bookCopyDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "changeBookCopyStatus", consumes = APPLICATION_JSON_VALUE)
    public BookCopyStatusDto changeBookCopyStatus(@RequestBody BookCopyStatusDto bookCopyStatusDto) {
        return libraryMapper.mapToBookCopyStatusDto(
                service.saveBookCopy(libraryMapper.mapToBookCopyFromStatus(bookCopyStatusDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getNumberOfBookCopies")
    public int getNumberOfBookCopies(@RequestParam Long id) {
        return service.countBookCopiesByTitleId(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "bookRental", consumes = APPLICATION_JSON_VALUE)
    public void bookRental(@RequestBody RentalDto rentalDto) {
        service.saveRental(libraryMapper.mapToRental(rentalDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "bookReturn", consumes = APPLICATION_JSON_VALUE)
    public RentalDateOfReturnDto bookReturn(@RequestBody RentalDateOfReturnDto rentalDateOfReturnDto) {
        return libraryMapper.mapToRentalDateOfReturnDto(
                service.saveRental(libraryMapper.mapToRentalFromDateOfReturn(rentalDateOfReturnDto)));
    }
}
