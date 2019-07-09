package com.library.service;

import com.library.domain.Loan;
import com.library.domain.Reader;
import com.library.repository.LoanRepository;
import com.library.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DbServiceLoan {

    @Autowired
    LoanRepository loanRepository;


    @Autowired
    ReaderRepository readerRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Optional<Loan> getLoan(Long id) {
        return loanRepository.findById(id);
    }

    public Loan saveLoan(final Loan loan) {

        return loanRepository.save(loan);
    }

    public void deleteLoan(final Long id) {
        loanRepository.deleteById(id);
    }

}
