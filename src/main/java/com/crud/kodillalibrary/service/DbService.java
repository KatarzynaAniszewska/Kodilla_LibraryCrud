package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.BookCopy;
import com.crud.kodillalibrary.domain.Reader;
import com.crud.kodillalibrary.domain.Rental;
import com.crud.kodillalibrary.domain.Title;
import com.crud.kodillalibrary.repository.BookCopyRepository;
import com.crud.kodillalibrary.repository.ReaderRepository;
import com.crud.kodillalibrary.repository.RentalRepository;
import com.crud.kodillalibrary.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DbService {
    @Autowired
    BookCopyRepository bookCopyRepository;
    @Autowired
    ReaderRepository readerRepository;
    @Autowired
    TitleRepository titleRepository;
    @Autowired
    RentalRepository rentalRepository;

    public BookCopy saveBookCopy(BookCopy bookCopy) {
        return bookCopyRepository.save(bookCopy);
    }

    public BookCopy getBookCopy(Long id) {return bookCopyRepository.getById(id);}

    public int countBookCopiesByTitleId(Long id) { return bookCopyRepository.countByTitle_Id(id); }

    public Reader saveReader (Reader reader) {
        return readerRepository.save(reader);
    }

    public Reader getReader(Long id) {return readerRepository.getById(id);}

    public Title saveTitle (Title title) { return titleRepository.save(title); }

    public Title getTitle(Long id) {return titleRepository.getById(id);}

    public Rental saveRental(Rental rental) {return rentalRepository.save(rental);}

    public Rental getRental(Long id) {return rentalRepository.getById(id);}
}
