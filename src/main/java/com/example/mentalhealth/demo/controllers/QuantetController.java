package com.example.mentalhealth.demo.controllers;

import com.example.mentalhealth.demo.beans.Person;
import com.example.mentalhealth.demo.beans.QuantetPerson;
import com.example.mentalhealth.demo.service.QuantetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class QuantetController {

    private static final Logger logger = LoggerFactory.getLogger(QuantetController.class);

    @Autowired
    private QuantetService quantetService;

    @GetMapping("/")
    public List<QuantetPerson> getPerson() throws IOException {
        return quantetService.getPersons();
    }

}
