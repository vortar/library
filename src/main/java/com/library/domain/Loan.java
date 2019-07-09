package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Target;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;


@Entity
@Table(name = "LOANS")
public class Loan {
    private Long id;
    private Date loanOfDate;
    private Date returnOfDate;
    private Book book;
    private Reader reader;

    public Loan() {

    }

    public Loan(Long id, Date loanOfDate, Date returnOfDate) {
        this.id = id;
        this.loanOfDate = loanOfDate;
        this.returnOfDate = returnOfDate;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID_LOAN", unique = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LOAN_OF_DATE")
    public Date getLoanOfDate() {
        return loanOfDate;
    }

    public void setLoanOfDate(Date loanOfDate) {
        this.loanOfDate = loanOfDate;
    }

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RETURN_OF_DATE")
    public Date getReturnOfDate() {
        return returnOfDate;
    }

    public void setReturnOfDate(Date returnOfDate) {
        this.returnOfDate = returnOfDate;
    }


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_BOOK")
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_READER")
    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }


}


