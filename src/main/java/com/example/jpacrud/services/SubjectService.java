package com.example.jpacrud.services;

import com.example.jpacrud.models.Student;
import com.example.jpacrud.models.Subject;
import com.example.jpacrud.models.Teacher;
import com.example.jpacrud.reposotries.StudentRepository;
import com.example.jpacrud.reposotries.SubjectRepository;
import com.example.jpacrud.reposotries.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject getSubject(Long id) {
        return subjectRepository.findById(id).orElse(null);
    }

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject updateSubject(Long id, Subject subject) {
        Subject subjectToUpdate = subjectRepository.findById(id).orElse(null);
        if (subjectToUpdate != null) {
            subjectToUpdate.setName(subject.getName());
            subjectToUpdate.setDescription(subject.getDescription());
            subjectRepository.save(subjectToUpdate);
        }
        return subjectToUpdate;
    }

    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    public Subject enrollStudentsBySubject(Long subjectId, Long studentId) {
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        Student student = studentRepository.findById(studentId).orElse(null);
        subject.enrollStudent(student);
        return subjectRepository.save(subject);
    }

    public Subject assignTeacherToSubject(Long subjectId, Long teacherId) {
        Subject subject = subjectRepository.findById(subjectId).orElse(null);
        Teacher teacher = teacherRepository.findById(teacherId).orElse(null);
        subject.assignTeacher(teacher);
        return subjectRepository.save(subject);
    }
}
