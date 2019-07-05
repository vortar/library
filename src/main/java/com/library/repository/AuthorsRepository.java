package com.library.repository;

import com.library.domain.AuthorsOfBooks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public interface AuthorsRepository extends CrudRepository <AuthorsOfBooks, Long> {

    @Override
    List<AuthorsOfBooks> findAll();
    @Override
    AuthorsOfBooks save(AuthorsOfBooks authorsOfBooks);
}

