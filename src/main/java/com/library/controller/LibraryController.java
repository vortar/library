package com.library.controller;


import com.library.domain.AuthorsOfBooks;
import com.library.domain.AuthorsOfBooksDto;
import com.library.domain.KindsOfBooks;
import com.library.domain.TitleOfBooks;
import com.library.libraryClient.LibraryClient;
import com.library.mapper.AuthorsMapper;
import com.library.service.DbServiceLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private LibraryClient libraryClient;

    @Autowired
    private AuthorsMapper authorsMapper;
    @Autowired
    private DbServiceLibrary dbServiceLibrary;

    @GetMapping(value = "kinds")
    public void getThemes() {
        List<KindsOfBooks> kindsOfBooks = libraryClient.getKindsOfBooks();

        kindsOfBooks.forEach(kindOfBooks -> System.out.println(kindOfBooks.getName()));

    }


    @GetMapping(value = "books")
    public void getTitleOfBooks() {
        List<TitleOfBooks> titleOfBooks = libraryClient.getBookTitle();

        titleOfBooks.forEach(titleOfBook -> System.out.println(titleOfBook.getTitle()));
    }

    @GetMapping(value = "authors")
    public void getAuthorsOfBooks() {
        List<AuthorsOfBooks> authorsOfBooks = libraryClient.getBookAuthor();

        authorsOfBooks.forEach(authorsOfBook -> System.out.println(authorsOfBook.getName()));
    }

    @GetMapping(value = "authorsList")
    public List<AuthorsOfBooksDto> getAuthorsOfBooksList() {
       return authorsMapper.mapToAuthorsDtoList(dbServiceLibrary.getAllAuthors());

    }

}
