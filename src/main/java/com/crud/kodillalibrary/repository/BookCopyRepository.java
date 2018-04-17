package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.BookCopy;
import com.crud.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface BookCopyRepository extends CrudRepository<BookCopy,Long> {
    @Override
    BookCopy save (BookCopy bookCopy);

    int countByTitle_Id(Long id);

    BookCopy getById(Long id);



}