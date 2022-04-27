package com.example.mentalhealth.demo.dao.impl;

import com.example.mentalhealth.demo.beans.Person;
import com.example.mentalhealth.demo.beans.QuantetPerson;
import com.example.mentalhealth.demo.dao.QuantetDao;
import com.example.mentalhealth.demo.repositories.AddressRepository;
import com.example.mentalhealth.demo.repositories.QuantetPersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class QuantetDaoImpl implements QuantetDao {

    private static final Logger logger = LoggerFactory.getLogger(QuantetDaoImpl.class);

    @Autowired
    public RestTemplate restTemplate;
    @Autowired
    public QuantetPersonRepository quantetPersonrepository;
    @Autowired
    public AddressRepository addressRepository;

    @Override
    public List<Person> getPersons() throws IOException {
        restTemplate.setMessageConverters(getJsonMessageConverters());
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Person> entity = new HttpEntity<>(headers);
        ResponseEntity<List<Person>> result = restTemplate.exchange("https://data.cityofnewyork.us/resource/8nqg-ia7v.json", HttpMethod.GET, entity, new ParameterizedTypeReference<>() {
        });
        return result.getBody();
    }

    private List<HttpMessageConverter<?>> getJsonMessageConverters() {
        List<HttpMessageConverter<?>> converters = new ArrayList<>();
        converters.add(new MappingJackson2HttpMessageConverter());
        return converters;
    }

    @Override
    public List<QuantetPerson> saveQuantetPerson(QuantetPerson quantetPerson) {
        logger.info(quantetPerson.getAddress().toString());
        addressRepository.save(quantetPerson.getAddress());
        logger.info(quantetPerson.toString());
        quantetPersonrepository.save(quantetPerson);
        return quantetPersonrepository.findAll();
    }

    @Override
    public List<QuantetPerson> getQuantetPersons() {
        return quantetPersonrepository.findAll();
    }
}
