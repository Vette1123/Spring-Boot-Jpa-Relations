package com.example.jpacrud.controllers;

import com.example.jpacrud.models.Subject;
import com.example.jpacrud.services.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping()
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @PostMapping()
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.createSubject(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }

    @PutMapping("/{id}/enroll/{studentId}")
    public Subject enrollStudentsBySubject(@PathVariable Long id, @PathVariable Long studentId) {
        return subjectService.enrollStudentsBySubject(id, studentId);
    }

    @PutMapping("/{id}/assign/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable Long id, @PathVariable Long teacherId) {
        return subjectService.assignTeacherToSubject(id, teacherId);
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);
    }

}
