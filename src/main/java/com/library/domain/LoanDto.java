package com.library.domain;

import java.time.LocalDate;

public class LoanDto {
    private Long id;
    private CopyDto copyDto;
    private ReaderDto readerDto;
    private Long id_copy;
    private Long id_reader;
    private String returned;
    private LocalDate loanOfDate = LocalDate.now();
    private LocalDate returnOfDate;

    public LoanDto() {}

    public LoanDto(Long id, Long id_copy, Long id_reader, String returned) {
        this.id = id;
        this.id_copy = id_copy;
        this.id_reader = id_reader;
        this.returned = returned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CopyDto getCopyDto() {
        return copyDto;
    }

    public void setCopyDto(CopyDto copyDto) {
        this.copyDto = copyDto;
    }

    public ReaderDto getReaderDto() {
        return readerDto;
    }

    public void setReaderDto(ReaderDto readerDto) {
        this.readerDto = readerDto;
    }

    public LocalDate getLoanOfDate() {
        return loanOfDate;
    }

    public void setLoanOfDate(LocalDate loanOfDate) {
        this.loanOfDate = loanOfDate;
    }

    public LocalDate getReturnOfDate() {
        return returnOfDate;
    }

    public void setReturnOfDate(LocalDate returnOfDate) {
        this.returnOfDate = returnOfDate;
    }

    public Long getId_copy() {
        return id_copy;
    }

    public void setId_copy(Long id_copy) {
        this.id_copy = id_copy;
    }

    public Long getId_reader() {
        return id_reader;
    }

    public void setId_reader(Long id_reader) {
        this.id_reader = id_reader;
    }

    public String getReturned() {
        return returned;
    }

    public void setReturned(String returned) {
        this.returned = returned;
    }
}