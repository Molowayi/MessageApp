package be.intecbrussel.eindwerkmolowayibackend.datLayer;

import be.intecbrussel.eindwerkmolowayibackend.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Long> {

    public List<Staff> findStaffByFirstName(String fn);
    public List<Staff> findStaffByLastName(String ln);

    Staff getStaffById(Long id);
}
