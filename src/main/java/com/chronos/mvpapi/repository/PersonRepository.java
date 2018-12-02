package com.chronos.mvpapi.repository;

import com.chronos.mvpapi.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, String> {

    Optional<Person> findByEmail(String email);


}
