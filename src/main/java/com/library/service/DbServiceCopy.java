package com.library.service;

import com.library.domain.Book;
import com.library.domain.Copy;
import com.library.repository.BookRepository;
import com.library.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DbServiceCopy {
    @Autowired
    CopyRepository copyRepository;

    @Autowired
    BookRepository bookRepository;

    public List<Copy> getAllCopies() {
        return copyRepository.findAll();
    }

    public Optional<Copy> getCopy(Long id) {
        return copyRepository.findById(id);
    }

    public Long getCopiesInLibraryForTitle (String title, String status) {
        List<Copy> copies = copyRepository.findByStatus(title);
        Long quantity = copies.stream()
                .filter(s -> s.getStatus().equals(status))
                .count();
        return quantity;
    }

    public Copy saveCopy(final Copy copy)
    {
        Optional<Book> bookOptional = bookRepository.findByTitle(copy.getTitle());
        Book book = bookOptional.get();
        copy.setBook(book);

        return copyRepository.save(copy);
    }

    public Copy saveCopy2(final Copy copy)
    {
        Optional<Book> bookOptional = bookRepository.findByTitle(copy.getTitle());

     //   if(!bookOptional.isPresent()) {

          //  System.out.println("That title hasn't in the base");
      //  } else {
            Book book = bookOptional.get();
            copy.setBook(book);
     //   }

        return copyRepository.save(copy);
    }

    public void deleteCopy(final Long id) {
        copyRepository.deleteById(id);
    }
}
