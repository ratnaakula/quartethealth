package com.example.mentalhealth.demo.service;

import com.example.mentalhealth.demo.beans.Address;
import com.example.mentalhealth.demo.beans.Person;
import com.example.mentalhealth.demo.beans.QuantetPerson;
import com.example.mentalhealth.demo.dao.QuantetDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuantetService {
    private static final Logger logger = LoggerFactory.getLogger(QuantetService.class);
    @Autowired
    private QuantetDao quantetDao;

    public List<QuantetPerson> getPersons() throws IOException {
        List<Person> persons = quantetDao.getPersons();
        List<Person> newYorkList = persons.stream().filter(person -> person.getCity().equalsIgnoreCase("NEW YORK")).collect(Collectors.toList());
        logger.info(String.valueOf(newYorkList.size()));
        List<QuantetPerson> quantetPerson = newYorkList.stream().map(person -> new QuantetPerson(person.getName_1(), person.getName_2(),
                        new Address(person.getStreet_1(), person.getCity(), person.getZip(), person.getPhone(), person.getLatitude(), person.getLongitude())))
                .collect(Collectors.toList());
        quantetPerson.forEach(person -> quantetDao.saveQuantetPerson(person));
        List<QuantetPerson> list = quantetDao.getQuantetPersons();
        return list;
    }
}
