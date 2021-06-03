package org.sakhnyasha.model;

import java.util.Objects;

public class Hotel {

    private String name;
    private String address;
    private String country;
    private String city;

    public Hotel() {
    }

    public Hotel(String name, String address, String country, String city) {
        this.name = name;
        this.address = address;
        this.country = country;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(name, hotel.name) && Objects.equals(address, hotel.address) && Objects.equals(country, hotel.country) && Objects.equals(city, hotel.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, country, city);
    }
}
