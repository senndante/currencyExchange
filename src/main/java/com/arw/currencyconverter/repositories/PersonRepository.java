package com.arw.currencyconverter.repositories;

import com.arw.currencyconverter.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);
}
