package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
  @Query(value = "SELECT  * FROM department JOIN  staff s ON department.id = s.department WHERE  s.id=?1", nativeQuery = true)
  Department findDepartmentOfStaffMemberGivenById(long id);
}
