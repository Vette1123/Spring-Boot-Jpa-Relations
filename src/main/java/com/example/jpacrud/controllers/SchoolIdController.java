package com.example.jpacrud.controllers;

import com.example.jpacrud.models.SchoolId;
import com.example.jpacrud.services.SchoolIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schoolId")
public class SchoolIdController {

    private final SchoolIdService schoolIdService;

    @GetMapping()
    public List<SchoolId> getAllSchoolIds() {
        return schoolIdService.getAllSchoolIds();
    }

    @GetMapping("/{id}")
    public SchoolId getSchoolId(@PathVariable Long id) {
        return schoolIdService.getSchoolId(id);
    }

    @PostMapping()
    public SchoolId createSchoolId(@RequestBody SchoolId schoolId) {
        return schoolIdService.createSchoolId(schoolId);
    }

}
