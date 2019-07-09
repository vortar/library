package com.library.libraryClient;

import com.library.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class LibraryClient {

    @Autowired
    private RestTemplate restTemplate;


    public List<Book> getBookTitle() {

        URI url = UriComponentsBuilder.fromHttpUrl("https://wolnelektury.pl/api/books/")
                .queryParam("fields", "title,author,kinds").build().encode().toUri();


        Book[] books = restTemplate.getForObject(url, Book[].class);

        if (books != null) {
            return Arrays.asList(books);
        }
        return new ArrayList<>();
    }
}
