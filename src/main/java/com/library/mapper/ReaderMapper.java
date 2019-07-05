package com.library.mapper;

import com.library.domain.Reader;
import com.library.domain.ReaderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReaderMapper {
    public Reader mapToReader(final ReaderDto readerDto) {
        return new Reader(
                readerDto.getId(),
                readerDto.getName(),
                readerDto.getSurname(),
                readerDto.getDateOfCardInsertion(),
                readerDto.getLoan());
    }

    public ReaderDto mapToReaderDto(final Reader reader) {
        return new ReaderDto(
                reader.getId(),
                reader.getName(),
                reader.getSurname(),
                reader.getDateOfCardInsertion(),
                reader.getLoan());
    }

    public List<ReaderDto> mapToReaderDtoList(final List<Reader> readerList) {
        return readerList.stream()
                .map(t -> new ReaderDto(t.getId(), t.getName(), t.getSurname(), t.getDateOfCardInsertion(), t.getLoan()))
                .collect(Collectors.toList());
    }

}
