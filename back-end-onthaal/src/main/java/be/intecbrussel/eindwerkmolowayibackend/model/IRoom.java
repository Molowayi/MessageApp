package be.intecbrussel.eindwerkmolowayibackend.model;

import java.util.List;

public interface IRoom {
    public long getId();
    public void setId(long id);
    public String getNumber();
    public void setNumber(String number);
    public Funktion getFunction();
    public void setFunction(Funktion function);
    public List<Student> getTenants();
    public void setTenants(List<Student> tenants);
}
