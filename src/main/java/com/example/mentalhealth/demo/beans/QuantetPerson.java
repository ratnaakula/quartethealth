package com.example.mentalhealth.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class QuantetPerson {

    public QuantetPerson() {
    }

    public QuantetPerson(String name_1, String name_2, Address address) {
        this.name_1 = name_1;
        this.name_2 = name_2;
        this.address = address;
    }

    @Id
    @GeneratedValue
    private Long id;
    private String name_1;
    private String name_2;
    @OneToOne(mappedBy = "quantetPerson")
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_1() {
        return name_1;
    }

    public void setName_1(String name_1) {
        this.name_1 = name_1;
    }

    public String getName_2() {
        return name_2;
    }

    public void setName_2(String name_2) {
        this.name_2 = name_2;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "QuantetPerson{" +
                "id=" + id +
                ", name_1='" + name_1 + '\'' +
                ", name_2='" + name_2 + '\'' +
                ", address=" + address +
                '}';
    }
}
