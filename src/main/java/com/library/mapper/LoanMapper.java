package com.library.mapper;

import com.library.domain.Loan;
import com.library.domain.LoanDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {
    public Loan mapToLoan(final LoanDto loanDto) {
        return new Loan(
                loanDto.getId(),
                loanDto.getLoanOfDate(),
                loanDto.getReturnOfDate());

    }

    public LoanDto mapToLoanDto(final Loan loan) {
        return new LoanDto(
                loan.getId(),
                loan.getLoanOfDate(),
                loan.getReturnOfDate());


    }

    public List<LoanDto> mapToLoanDtoList(final List<Loan> loanList) {
        return loanList.stream()
                .map(t -> new LoanDto(t.getId(), t.getLoanOfDate(), t.getReturnOfDate()))
                .collect(Collectors.toList());
    }

}