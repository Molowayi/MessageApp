package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.StudentDAO;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.RoomRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Room;
import be.intecbrussel.eindwerkmolowayibackend.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class StudentController {

  @Autowired
  StudentDAO studentDAO;

  @Autowired
  RoomRepository roomRepository;

  @Secured("ROLE_ADMIN")
  @PostMapping(value = "/student", produces = "application/json", consumes = "application/json")
  public Student createStudent(@RequestBody Student student) {
    Optional<Room> optionalRoom = roomRepository.findById(student.getRoom().getId());
    if (optionalRoom.isPresent()) student.setRoom(optionalRoom.get());
    return studentDAO.save(student);
  }

  @GetMapping(value = "/student", produces = "application/json")
  public List<Student> getAllStudents() {
    return studentDAO.findAll();
  }

  @GetMapping(value = "/student/{id}", produces = "application/json")
  public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long id) {
    HttpStatus status = HttpStatus.OK;
    Student student = studentDAO.getStudentById(id);
    if (student == null) {
      status = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<>(student, status);
  }
  @Secured("ROLE_ADMIN")
  @PutMapping(value = "/student/{id}", produces = "application/json")
  public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentid, @RequestBody Student studentDetails) {
    Student student = studentDAO.findOne(studentid);
    if (student == null) {
      return ResponseEntity.notFound().build();
    }

    student.setSchool(studentDetails.getSchool());
    student.setStudy_field(studentDetails.getStudy_field());
    student.setRoom(studentDetails.getRoom());
    student.setFirstName(studentDetails.getFirstName());
    student.setLastName(studentDetails.getLastName());
    student.setBirthDate(studentDetails.getBirthDate());
    student.setSent_messages(studentDetails.getSent_messages());
    student.setReceived_messages(studentDetails.getReceived_messages());
    student.setContact(studentDetails.getContact());
    student.setSent_messages(studentDetails.getSent_messages());
    student.setStatus(studentDetails.getStatus());

    Student updateStudent = studentDAO.save(student);
    return ResponseEntity.ok().body(updateStudent);
  }

  @Secured("ROLE_ADMIN")
  @DeleteMapping(value = "/student/{id}", produces = "application/json")
  public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentid) {
    Student student = studentDAO.findOne(studentid);
    if (student == null) {
      return ResponseEntity.notFound().build();
    }
    studentDAO.delete(student);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/student/firstname/{fn}", produces = "application/json")
  public List<Student> findByFirstName(@PathVariable(value = "fn") String firstname) {
    return studentDAO.findStudentByFirstName(firstname);
  }

  @GetMapping(value = "/student/lastname/{ln}", produces = "application/json")
  public List<Student> findByLast(@PathVariable(value = "ln") String lastname) {
    return studentDAO.findStudentByLastName(lastname);
  }
}
