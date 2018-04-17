package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Reader;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<Reader,Long> {

    @Override
    Reader save (Reader reader);

    Reader getById(Long id);


}
