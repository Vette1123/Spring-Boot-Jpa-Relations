package com.example.jpacrud.services;

import com.example.jpacrud.models.Student;
import com.example.jpacrud.reposotries.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public Student createStudent( Student student) {
       return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Long id, Student student) {
        Student studentToUpdate = studentRepository.findById(id).orElse(null);
        studentToUpdate.setName(student.getName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setEmail(student.getEmail());
        return studentRepository.save(studentToUpdate);
    }

    public void deleteStudent(Long id) {
        studentRepository.findById(id).ifPresent(student -> studentRepository.delete(student));
    }
}
