package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

public class LoanDto {

    private Long id;
    private Date loanOfDate;
    private Date returnOfDate;
    private Book Book;
    private Reader reader;

    public LoanDto() {

    }

    public LoanDto(Long id, Date loanOfDate, Date returnOfDate) {
        this.id = id;
        this.loanOfDate = loanOfDate;
        this.returnOfDate = returnOfDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLoanOfDate() {
        return loanOfDate;
    }

    public void setLoanOfDate(Date loanOfDate) {
        this.loanOfDate = loanOfDate;
    }

    public Date getReturnOfDate() {
        return returnOfDate;
    }

    public void setReturnOfDate(Date returnOfDate) {
        this.returnOfDate = returnOfDate;
    }

    public com.library.domain.Book getBook() {
        return Book;
    }

    public void setBook(com.library.domain.Book book) {
        Book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

}