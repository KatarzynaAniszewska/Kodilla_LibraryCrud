package com.crud.kodillalibrary.repository;

import com.crud.kodillalibrary.domain.Title;
import org.springframework.data.repository.CrudRepository;

public interface TitleRepository extends CrudRepository<Title,Long> {

    @Override
    Title save (Title title);

    Title getById(Long id);
}

