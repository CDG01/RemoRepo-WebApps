package com.develhope.Ospedale.controllers;

import com.develhope.Ospedale.dtos.DottoreDto;
import com.develhope.Ospedale.services.DottoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dottori")
public class DottoreController {

    @Autowired
    private DottoreService dottoreService;

    @PostMapping
    public DottoreDto createDottore(@RequestBody DottoreDto dottoreDto) {
        return dottoreService.createDottore(dottoreDto);
    }

    @GetMapping
    public List<DottoreDto> getAllDottori() {
        return dottoreService.getAllDottore();
    }

    @GetMapping("/{id}")
    public DottoreDto findById(@PathVariable Long id) {
        return dottoreService.findById(id);
    }

    @PutMapping("/{id}")
    public DottoreDto update(@PathVariable Long id, @RequestBody DottoreDto dottoreDto) {
        return dottoreService.update(dottoreDto);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return dottoreService.delete(id);
    }
}