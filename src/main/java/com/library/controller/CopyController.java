package com.library.controller;

import com.library.domain.CopyDto;
import com.library.mapper.CopyMapper;
import com.library.service.DbServiceCopy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("copy/")
public class CopyController {
    @Autowired
    private DbServiceCopy dbServiceCopy;

    @Autowired
    private CopyMapper copyMapper;

    @GetMapping( value = "getCopies")
    public List<CopyDto> getCopies() {
        return copyMapper.mapToCopyDtoList(dbServiceCopy.getAllCopies());
    }

    @GetMapping( value = "getCopy")
    public CopyDto getCopy(@RequestParam Long copyId) throws ObjectNotFoundException {
        return copyMapper.mapToCopyDto(dbServiceCopy.getCopy(copyId).orElseThrow(ObjectNotFoundException::new));
    }

    @DeleteMapping( value = "deleteCopy")
    public void deleteCopy(@RequestParam Long copyId) {
        dbServiceCopy.deleteCopy(copyId);
    }

    @PutMapping( value = "updateCopy")
    public CopyDto updateCopy(@RequestBody CopyDto copyDto) {
        return copyMapper.mapToCopyDto(dbServiceCopy.saveCopy(copyMapper.mapToCopy(copyDto)));
    }

    @PostMapping( value = "createCopy", consumes = APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        dbServiceCopy.saveCopy2(copyMapper.mapToCopy(copyDto));
    }
}
