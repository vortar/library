package com.library.controller;

import com.library.domain.BookDto;
import com.library.mapper.BookMapper;
import com.library.service.DbServiceBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private DbServiceBook dbServiceBook;

    @Autowired
    private BookMapper bookMapper;

    @GetMapping( value = "getBooks")
    public List<BookDto> getBooks() {
        return bookMapper.mapToBookDtoList(dbServiceBook.getAllBooks());
    }

    @GetMapping( value = "getBook{bookId}")
    public BookDto getBook(@PathVariable Long bookId) throws ObjectNotFoundException {
        return bookMapper.mapToBookDto(dbServiceBook.getBook(bookId).orElseThrow(ObjectNotFoundException::new));
    }

    @GetMapping( value = "getBookTitle/")
    public BookDto getBookTitle(@RequestParam String bookTitle) throws ObjectNotFoundException {
        return bookMapper.mapToBookDto(dbServiceBook.getBookTitle(bookTitle).orElseThrow(ObjectNotFoundException::new));
    }

    @DeleteMapping( value = "deleteBook/{bookId}")
    public void deleteBook(@PathVariable Long bookId) {
        dbServiceBook.deleteBook(bookId);
    }

    @PutMapping( value = "updateBook")
    public BookDto updateBook(@RequestBody BookDto bookDto) {
        return bookMapper.mapToBookDto(dbServiceBook.saveBook(bookMapper.mapToBook(bookDto)));
    }

    @PostMapping( value = "createBook", consumes = APPLICATION_JSON_VALUE)
    public void createBook(@RequestBody BookDto bookDto) {
        dbServiceBook.saveBook(bookMapper.mapToBook(bookDto));
    }
}
