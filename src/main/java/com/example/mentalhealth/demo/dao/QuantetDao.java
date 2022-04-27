package com.example.mentalhealth.demo.dao;

import com.example.mentalhealth.demo.beans.Person;
import com.example.mentalhealth.demo.beans.QuantetPerson;

import java.io.IOException;
import java.util.List;

public interface QuantetDao {
    List<Person> getPersons() throws IOException;

    List<QuantetPerson> saveQuantetPerson(QuantetPerson quantetPerson);

    List<QuantetPerson> getQuantetPersons();
}
