package be.intecbrussel.eindwerkmolowayibackend.model;

public interface IAdress {

    public long getId();

    public void setId(long id);

    public String getStreet();

    public void setStreet(String street);

    public String getNumber();

    public void setNumber(String number);

    public String getZipCode();

    public void setZipCode(String zipCode);

    public String getCity();

    public void setCity(String city);

    public String getCountry();

    public void setCountry(String country);
}
