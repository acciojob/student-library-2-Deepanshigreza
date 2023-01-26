package com.driver.services;

import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;





    public Student getDetailsByEmail(String email){
        Student student = studentRepository4.findByEmailId(email);
        return student;
    }

    public Student getDetailsById(int id){
        Student student = studentRepository4.findById(id).get();
        return student;
    }

    public void createStudent(Student student){
        studentRepository4.save(student);
    }

    public void updateStudent(Student student){
//        Student studentEntity = new Student();
//        studentEntity.setEmailId(student.getEmailId());
//        studentEntity.setName(student.getName());
//        studentEntity.setAge(student.getAge());
//        studentEntity.setCountry(student.getCountry());
//
//        studentRepository4.save(studentEntity);
        studentRepository4.updateStudentDetails(student);
        studentRepository4.save(student);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
        studentRepository4.deleteById(id);
        cardService4.deactivateCard(id);
    }
}
