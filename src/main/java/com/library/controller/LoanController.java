package com.library.controller;

import com.library.domain.LoanDto;
import com.library.mapper.LoanMapper;
import com.library.service.DbServiceLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("loan/")
public class LoanController {
    @Autowired
    private DbServiceLoan dbServiceLoan;

    @Autowired
    private LoanMapper loanMapper;

    @GetMapping( value = "getLoans")
    public List<LoanDto> getLoans() {
        return loanMapper.mapToLoanDtoList(dbServiceLoan.getAllLoans());
    }

    @GetMapping( value = "getLoan")
    public LoanDto getLoan(@RequestParam Long loanId) throws ObjectNotFoundException {
        return loanMapper.mapToLoanDto(dbServiceLoan.getLoan(loanId).orElseThrow(ObjectNotFoundException::new));
    }

    @DeleteMapping( value = "deleteLoan")
    public void deleteLoan(@RequestParam Long loanId) {
        dbServiceLoan.deleteLoan(loanId);
    }

    @PutMapping( value = "updateLoan")
    public LoanDto updateLoan(@RequestBody LoanDto loanDto) {
        return loanMapper.mapToLoanDto(dbServiceLoan.saveLoan(loanMapper.mapToLoan(loanDto)));
    }

    @PostMapping( value = "createLoan", consumes = APPLICATION_JSON_VALUE)
    public void createLoan(@RequestBody LoanDto loanDto) {
        dbServiceLoan.saveLoan(loanMapper.mapToLoan(loanDto));
    }
}
