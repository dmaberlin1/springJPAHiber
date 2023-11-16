package com.dmadev.springJPAHiber.repositories;

import com.dmadev.springJPAHiber.models.Car;
import com.dmadev.springJPAHiber.models.ColorCar;
import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.models.TypeBodyCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    List<Car> findByTypeBody(TypeBodyCar typeBody);

    List<Car> findByColor(ColorCar color);


    List<Car> findByOwner(Person owner);
}
