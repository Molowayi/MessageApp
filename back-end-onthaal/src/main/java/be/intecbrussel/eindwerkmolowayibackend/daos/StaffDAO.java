package be.intecbrussel.eindwerkmolowayibackend.daos;

import be.intecbrussel.eindwerkmolowayibackend.datLayer.StaffRepository;
import be.intecbrussel.eindwerkmolowayibackend.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffDAO {

    @Autowired
    StaffRepository staffRepository;


    public  synchronized Staff save(Staff staff) {
        return staffRepository.save(staff);
    }

    public  synchronized List<Staff> findAll() {
        return staffRepository.findAll();
    }

    public  synchronized Staff findOne(Long id) {
        return staffRepository.getOne(id);
    }

    public synchronized  void delete(Staff staff) {
        staffRepository.delete(staff);
    }

    public synchronized  List<Staff> findStaffByFirstName(String fn){
        return staffRepository.findStaffByFirstName(fn);
    }

    public synchronized  List<Staff> findStaffByLastName(String ln){
        return staffRepository.findStaffByLastName(ln);
    }

    public Staff getStaffById(Long id) {
        return staffRepository.getStaffById(id);
    }
}
