package com.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ReaderDto {
    private Long id;
    private String name;
    private String surname;
    private LocalDate localDate;
    private Loan loan;

}
