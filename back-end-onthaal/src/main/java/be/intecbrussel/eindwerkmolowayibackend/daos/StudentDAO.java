package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.StudentRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAO {
    
    @Autowired
    StudentRepository studentRepository;


    public  synchronized Student save(Student student) {
        return studentRepository.save(student);
    }

    public  synchronized List<Student> findAll() {
        return studentRepository.findAll();
    }

    public  synchronized Student findOne(Long id) {
        return studentRepository.getOne(id);
    }

    public  synchronized void delete(Student student) {
        studentRepository.delete(student);
    }

    public  synchronized List<Student> findStudentByFirstName(String street){
        return studentRepository.findStudentByFirstName(street);
    }

    public synchronized  List<Student> findStudentByLastName(String street){
        return studentRepository.findStudentByLastName(street);
    }

    public Student getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }
}
