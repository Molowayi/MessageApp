package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.StaffDAO;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.DepartmentRepository;
import be.intecbrussel.eindwerkmolowayibackend.datLayer.StaffRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Department;
import be.intecbrussel.eindwerkmolowayibackend.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/ngo")
public class StaffController {

  @Autowired
  StaffDAO staffDAO;

  @Autowired
  DepartmentRepository departmentRepository;

  @PostMapping(value = "/staff", produces = "application/json")
  public Staff createStaff(@RequestBody Staff staff) {
    System.out.println(staff);
    Optional<Department> optionalDepartment = departmentRepository.findById(staff.getDepartment().getId());
    if (optionalDepartment.isPresent()){
      staff.setDepartment(optionalDepartment.get());
    }
    return staffDAO.save(staff);
  }

  @GetMapping(value = "/staff", produces = "application/json")
  public List<Staff> getAllStaffs() {
    return staffDAO.findAll();
  }

  @GetMapping(value = "/staff/{id}", produces = "application/json")
  public ResponseEntity<Staff> getStaffById(@PathVariable(value = "id") Long id) {
    HttpStatus status = HttpStatus.OK;
    Staff staff = staffDAO.getStaffById(id);

    if (staff == null) {
      status = HttpStatus.NOT_FOUND;
    }
    return new ResponseEntity<>(staff, status);
  }

  @PutMapping(value = "/staff/{id}", produces = "application/json")
  public ResponseEntity<Staff> updateStaff(@PathVariable(value = "id") Long staffid, @RequestBody Staff staffDetails) {

    Staff staff = staffDAO.findOne(staffid);
    if (staff == null) {
      return ResponseEntity.notFound().build();
    }

    staff.setDepartment(staffDetails.getDepartment());
    staff.setRole(staffDetails.getRole());
    staff.setFirstName(staffDetails.getFirstName());
    staff.setLastName(staffDetails.getLastName());
    staff.setBirthDate(staffDetails.getBirthDate());
    staff.setSent_messages(staffDetails.getSent_messages());
    staff.setReceived_messages(staffDetails.getReceived_messages());
    staff.setContact(staffDetails.getContact());
    staff.setSent_messages(staffDetails.getSent_messages());
    staff.setStatus(staffDetails.getStatus());

    Staff updateStaff = staffDAO.save(staff);
    return ResponseEntity.ok().body(updateStaff);
  }

  @DeleteMapping(value = "/staff/{id}", produces = "application/json")
  public ResponseEntity<Staff> deleteStaff(@PathVariable(value = "id") Long id) {

    Staff staff = staffDAO.findOne(id);
    if (staff == null) {
      return ResponseEntity.notFound().build();
    }
    staffDAO.delete(staff);
    return ResponseEntity.ok().build();
  }

  @GetMapping(value = "/staff/firstname/{fn}", produces = "application/json")
  public List<Staff> findByFirstName(@PathVariable(value = "fn") String firstname) {
    return staffDAO.findStaffByFirstName(firstname);
  }

  @GetMapping(value = "/staff/lastname/{ln}", produces = "application/json")
  public List<Staff> findByLast(@PathVariable(value = "ln") String lastname) {
    return staffDAO.findStaffByLastName(lastname);
  }
}
