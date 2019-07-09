package com.library.controller;


import com.library.domain.*;
import com.library.libraryClient.LibraryClient;
import com.library.service.DbServiceBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("library")
public class LibraryController {

    @Autowired
    private LibraryClient libraryClient;

    @Autowired
    private DbServiceBook dbServiceBook;

    @GetMapping(value = "title")
    public void getTitleOfBooks() {
        List<Book> books = libraryClient.getBookTitle();

       for (Book book : books){
           dbServiceBook.saveBook(book);
        }
    }




}
