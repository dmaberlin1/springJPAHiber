package com.dmadev.springJPAHiber.repositories;

import com.dmadev.springJPAHiber.models.IdenticalCode;
import com.dmadev.springJPAHiber.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdenticalRepository extends JpaRepository<IdenticalCode,Integer> {

    List<IdenticalCode> findByCodeNumber(Integer codeNumber);

    List<IdenticalCode> findByPerson(Person person);
}
