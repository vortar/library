package com.library.mapper;

import com.library.domain.Book;
import com.library.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {
    public Book mapToBook(final BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthors(),
                bookDto.getKind(),
                bookDto.getCopies());


    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getKind(),
                book.getCopies());

    }

    public List<BookDto> mapToBookDtoList(final List<Book> bookList) {
        return bookList.stream()
                .map(t -> new BookDto(t.getId(), t.getTitle(), t.getAuthor(), t.getKind(), t.getCopies()))
                .collect(Collectors.toList());
    }
}
