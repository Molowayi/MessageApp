package be.intecbrussel.eindwerkmolowayibackend.model;

import java.util.List;

public interface IDepartment {
    public long getId();

    public void setId(long id);

    public String getName();

    public void setName(String name);

    public List<Staff> getStaffList();

    public void setStaffList(List<Staff> staffList);
}
