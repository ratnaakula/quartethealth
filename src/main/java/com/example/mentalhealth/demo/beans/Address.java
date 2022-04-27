package com.example.mentalhealth.demo.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Address {

    public Address() {
    }

    public Address(String street_1, String city, String zip, String phone, String latitude, String longitude) {
        this.street_1 = street_1;
        this.city = city;
        this.zip = zip;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String street_1;
    private String city;
    private String zip;
    private String phone;
    private String latitude;
    private String longitude;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private QuantetPerson quantetPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet_1() {
        return street_1;
    }

    public void setStreet_1(String street_1) {
        this.street_1 = street_1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public QuantetPerson getQuantetPerson() {
        return quantetPerson;
    }

    public void setQuantetPerson(QuantetPerson quantetPerson) {
        this.quantetPerson = quantetPerson;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street_1='" + street_1 + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", phone='" + phone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
