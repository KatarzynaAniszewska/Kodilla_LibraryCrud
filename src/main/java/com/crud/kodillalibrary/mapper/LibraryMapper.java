package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.*;
import com.crud.kodillalibrary.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {
    @Autowired
    DbService service;

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto) {
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getStatus(),
                service.getTitle(bookCopyDto.getTitle_id())
        );
    }
    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy) {
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getStatus(),
                bookCopy.getTitle().getId()///????????????????????????????
        );
    }
    public BookCopy mapToBookCopyFromStatus(final BookCopyStatusDto bookCopyStatusDto) {
        return new BookCopy(
                bookCopyStatusDto.getId(),
                bookCopyStatusDto.getStatus(),
                service.getBookCopy(bookCopyStatusDto.getId()).getTitle()
        );
    }
    public BookCopyStatusDto mapToBookCopyStatusDto(final BookCopy bookCopy) {
        return new BookCopyStatusDto(
                bookCopy.getId(),
                bookCopy.getStatus()
        );
    }
    public Reader mapToReader(ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getDateOfStartingMembership()
        );
    }
    public ReaderDto mapToReaderDto(Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getDateOfStartingMembership()
        );
    }
    public Rental mapToRental(RentalDto rentalDto) {
        return new Rental(
                rentalDto.getId(),
                rentalDto.getDateOfRental(),
                rentalDto.getDateOfReturn(),
                service.getReader(rentalDto.getReader_id()),
                service.getBookCopy(rentalDto.getBookCopy_id())
        );
    }
    public RentalDto mapToRentalDto(Rental rental) {
        return new RentalDto(
                rental.getId(),
                rental.getDateOfRental(),
                rental.getDateOfReturn(),
                service.getRental(rental.getId()).getReader().getId(),
                service.getRental(rental.getId()).getBookCopy().getId()
        );
    }
    public RentalDateOfReturnDto mapToRentalDateOfReturnDto(Rental rental) {
        return new RentalDateOfReturnDto(
                rental.getId(),
                rental.getDateOfReturn()
        );
    }
    public Rental mapToRentalFromDateOfReturn(RentalDateOfReturnDto rentalDateOfReturnDto) {
        return new Rental(
                rentalDateOfReturnDto.getId(),
                service.getRental(rentalDateOfReturnDto.getId()).getDateOfRental(),
                rentalDateOfReturnDto.getDateOfReturn(),
                service.getRental(rentalDateOfReturnDto.getId()).getReader(),
                service.getRental(rentalDateOfReturnDto.getId()).getBookCopy()
        );
    }

    public Title mapToTitle(TitleDto titleDto) {
        return new Title(
                titleDto.getId(),
                titleDto.getTitle(),
                titleDto.getAuthor(),
                titleDto.getPublicationYear()
        );
    }
    public TitleDto mapToTitleDto(Title title) {
        return new TitleDto(
                title.getId(),
                title.getTitle(),
                title.getAuthor(),
                title.getPublicationYear()
        );
    }
}
