package com.example.mentalhealth.demo.repositories;

import com.example.mentalhealth.demo.beans.QuantetPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantetPersonRepository extends JpaRepository<QuantetPerson, Integer> {

}
