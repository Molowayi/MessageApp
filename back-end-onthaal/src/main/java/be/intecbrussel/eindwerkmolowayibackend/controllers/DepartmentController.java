package be.intecbrussel.eindwerkmolowayibackend.controllers;

import be.intecbrussel.eindwerkmolowayibackend.daos.DepartmentDAO;
import be.intecbrussel.eindwerkmolowayibackend.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/ngo")
public class DepartmentController {

  @Autowired
  DepartmentDAO departmentDAO;

  @GetMapping(value = "/department/staff/{id}", produces = "application/json", consumes = "application/json")
  public Department getDepartmentOfTheStaffMember(@PathVariable(value = "id") long id) {
    return departmentDAO.findDepartmentOfStaffMemberGivenById(id);
  }
}
