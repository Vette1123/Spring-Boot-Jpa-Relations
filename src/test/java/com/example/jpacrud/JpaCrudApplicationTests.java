package com.example.jpacrud;

import com.example.jpacrud.models.Student;
import com.example.jpacrud.models.Subject;
import com.example.jpacrud.models.Teacher;
import com.example.jpacrud.reposotries.StudentRepository;
import com.example.jpacrud.reposotries.SubjectRepository;
import com.example.jpacrud.reposotries.TeacherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaCrudApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    public void createTeacher (){
        Teacher teacher = new Teacher();
        teacher.setName("Teacher 1");
        teacherRepository.save(teacher);
        assert teacher.getId() != null;
    }

    @Test
    public void createStudent (){
        Student student = new Student();
        student.setName("Student 1");
        studentRepository.save(student);
        assert student.getId() != null;
    }

    @Test
    public void createSubject(){
        Subject subject = new Subject();
        subject.setName("Subject 1");
        subject.setDescription("Description 1");
        subjectRepository.save(subject);
        assert subject.getId() != null;
    }

    @Test
    public void createStudentSubject(){
        Student student = new Student();
        student.setName("Student 1");
        studentRepository.save(student);
        Subject subject = new Subject();
        subject.setName("Subject 1");
        subject.setDescription("Description 1");
        subject.enrollStudent(student);
        subjectRepository.save(subject);
        assert subject.getId() != null;
    }

    @Test
    public void deleteStudent(){
        Student student = new Student();
        student.setName("Student 1");
        studentRepository.save(student);
        studentRepository.delete(student);
        assert studentRepository.findById(student.getId()).isPresent() == false;
    }

    @Test
    public void deleteSubject(){
        Subject subject = new Subject();
        subject.setName("Subject 1");
        subject.setDescription("Description 1");
        subjectRepository.save(subject);
        subjectRepository.delete(subject);
        assert subjectRepository.findById(subject.getId()).isPresent() == false;
    }

}
