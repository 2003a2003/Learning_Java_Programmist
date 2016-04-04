package lesson4.part_03.frame_08;

public class Address {
    private String city;
    private String street;
    private int house;

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Address)) {
            return false;
        }
        Address adr = (Address) obj;
        return (city != null && city.equals(adr.getCity()) && (street != null && street.equals(adr.getStreet())
                && house == adr.getHouse()));
    }

    @Override
    public int hashCode() {
        final int perem = 50;
        int rez = 5;
        rez = 37 * rez + city.hashCode();
        rez = 37 * rez + street.hashCode();
        rez = 37 * rez + house;
        return rez;
    }
}
