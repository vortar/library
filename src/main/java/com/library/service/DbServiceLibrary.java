package com.library.service;

import com.library.domain.AuthorsOfBooks;
import com.library.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DbServiceLibrary {

    @Autowired
    AuthorsRepository authorsRepository;
    public List<AuthorsOfBooks> getAllAuthors(){
        return authorsRepository.findAll();
    }
}
