package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.DepartmentRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDAO {
  @Autowired
    DepartmentRepository departmentRepository;
  public Department findDepartmentOfStaffMemberGivenById(long id){
    return departmentRepository.findDepartmentOfStaffMemberGivenById(id);
  }
}
