package com.example.jpacrud.services;

import com.example.jpacrud.models.Teacher;
import com.example.jpacrud.reposotries.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher getTeacher(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher updateTeacher(Long id, Teacher teacher) {
        Teacher teacherToUpdate = teacherRepository.findById(id).orElse(null);
        if (teacherToUpdate != null) {
            teacherToUpdate.setName(teacher.getName());
            teacherRepository.save(teacherToUpdate);
        }
        return teacherToUpdate;
    }

    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
