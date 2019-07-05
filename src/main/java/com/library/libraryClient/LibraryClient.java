package com.library.libraryClient;

import com.library.domain.AuthorsOfBooks;
import com.library.domain.KindsOfBooks;
import com.library.domain.TitleOfBooks;
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

    public List<KindsOfBooks> getKindsOfBooks(){

        URI url = UriComponentsBuilder.fromHttpUrl("https://wolnelektury.pl/api/kinds/")
                .queryParam("fields","name").build().encode().toUri();

        KindsOfBooks[] librarykinds = restTemplate.getForObject(url, KindsOfBooks[].class);

        if (librarykinds != null){
            return Arrays.asList(librarykinds);
        }
        return new ArrayList<>();
    }

    public List<TitleOfBooks> getBookTitle(){

        URI url = UriComponentsBuilder.fromHttpUrl("https://wolnelektury.pl/api/books/")
                .queryParam("fields","title").build().encode().toUri();

        TitleOfBooks[] titleOfBooks = restTemplate.getForObject(url, TitleOfBooks[].class);

        if (titleOfBooks != null){
            return Arrays.asList(titleOfBooks);
        }
        return new ArrayList<>();
    }
    public List<AuthorsOfBooks> getBookAuthor(){

        URI url = UriComponentsBuilder.fromHttpUrl("https://wolnelektury.pl/api/authors/")
                .queryParam("fields","name").build().encode().toUri();

        AuthorsOfBooks[] authorsOfBooks = restTemplate.getForObject(url, AuthorsOfBooks[].class);

        if (authorsOfBooks != null){
            return Arrays.asList(authorsOfBooks);
        }
        return new ArrayList<>();
    }
}
