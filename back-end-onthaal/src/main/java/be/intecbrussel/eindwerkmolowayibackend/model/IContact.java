package be.intecbrussel.eindwerkmolowayibackend.model;

import java.util.Set;

public interface IContact {

    public long getId();

    public void setId(long id);

    public String getEmail();

    public void setEmail(String email);

    public String getMobile();

    public void setMobile(String mobile);

    public Set<Adress> getAdresses();
    public void setAdresses(Set<Adress> adresses);

}
