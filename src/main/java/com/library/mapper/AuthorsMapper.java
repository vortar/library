package com.library.mapper;

import com.library.domain.AuthorsOfBooks;
import com.library.domain.AuthorsOfBooksDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class AuthorsMapper {

    public AuthorsOfBooks mapToAuthorsDto(final AuthorsOfBooksDto authorsOfBooksDto) {
        return new AuthorsOfBooks(
                authorsOfBooksDto.getId(),
                authorsOfBooksDto.getName());
    }

    public AuthorsOfBooks mapToAuthors(final AuthorsOfBooks authorsOfBooks) {
        return new AuthorsOfBooks(
                authorsOfBooks.getId(),
                authorsOfBooks.getName());
    }

    public List<AuthorsOfBooksDto> mapToAuthorsDtoList(final List<AuthorsOfBooks> authorsOfBooksList){
        return authorsOfBooksList.stream()
                .map(a -> new AuthorsOfBooksDto(a.getId(),a.getName()))
                .collect(Collectors.toList());
    }
}
