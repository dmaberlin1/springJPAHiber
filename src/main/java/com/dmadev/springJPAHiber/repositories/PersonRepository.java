package com.dmadev.springJPAHiber.repositories;

import com.dmadev.springJPAHiber.models.Gender;
import com.dmadev.springJPAHiber.models.Lang;
import com.dmadev.springJPAHiber.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer>{
    List<Person> findByAge(int age);

    List<Person> findByGender(Gender gender);

    List<Person> findByLanguage(Lang language);

    List<Person> findByEmail(String email);

    List<Person> findByNameOrderByAge(String name);

    List<Person> findByNameStartingWith(String startingWith);

    List<Person> findByNameOrEmail(String name,String email);
}
