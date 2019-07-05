package com.library.controller;

import com.library.domain.ReaderDto;
import com.library.mapper.ReaderMapper;
import com.library.service.DbServiceReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("reader/")
public class ReaderController {

    @Autowired
    private DbServiceReader dbServiceReader;

    @Autowired
    private ReaderMapper readerMapper;

    @GetMapping( value = "getReaders")
    public List<ReaderDto> getReaders() {
        return readerMapper.mapToReaderDtoList(dbServiceReader.getAllReaders());
    }

    @GetMapping( value = "getReader")
    public ReaderDto getReader(@RequestParam Long readerId) throws ObjectNotFoundException {
        return readerMapper.mapToReaderDto(dbServiceReader.getReader(readerId).orElseThrow(ObjectNotFoundException::new));
    }

    @DeleteMapping( value = "deleteReader")
    public void deleteReader(@RequestParam Long readerId) {
        dbServiceReader.deleteReader(readerId);
    }

    @PutMapping( value = "updateReader")
    public ReaderDto updateReader(@RequestBody ReaderDto readerDto) {
        return readerMapper.mapToReaderDto(dbServiceReader.saveReader(readerMapper.mapToReader(readerDto)));
    }

    @PostMapping( value = "createReader", consumes = APPLICATION_JSON_VALUE)
    public void createReader(@RequestBody ReaderDto readerDto) {
        dbServiceReader.saveReader(readerMapper.mapToReader(readerDto));
    }
}