package com.dmadev.springJPAHiber.services;


import com.dmadev.springJPAHiber.models.Car;
import com.dmadev.springJPAHiber.models.ColorCar;
import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.models.TypeBodyCar;
import com.dmadev.springJPAHiber.repositories.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
//во всех по дефолту  будет  рид онли, в нужных изменить в ручную на false
public class CarService {
        /*мы не можем напрямую вызывать из репы
      - мы должны вызывать внутри хибер транзакции, транзакциями в том числе занимается сервис
       */

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public List<Car> findByTypeBody(TypeBodyCar typeBody){
        return carRepository.findByTypeBody(typeBody);
    }

    public List<Car> findByColor(ColorCar color){
        return carRepository.findByColor(color);
    }

    public List<Car> findByOwner(Person person){
        return carRepository.findByOwner(person);
    }


    public Car findOne(int id){
        Optional<Car> byId = carRepository.findById(id);
        return byId.orElse(null);
    }

    @Transactional // пометили транзакцией, для того чтобы был дефолт readonly=false
    public void save(Car car){
        carRepository.save(car);
    }

    @Transactional
    public void update(int id,Car updatedCar){
        updatedCar.setId(id);
        carRepository.save(updatedCar);

        //для обновления и сохранения в репе используется один метод
        //метод сейв увидит что передается человек который уже есть в таблице, и потому этого человека не будет сохранять,
        // а обновит значение у существующего человека
        //поэтому именно этому человеку в качестве сеттера указали айди ,чтобы метод сейв понимал что в этой таблице уже есть человек с таким айди
        //        и не нужно создавать, а просто обновит
    }

    @Transactional
    public void delete(int id){
        carRepository.deleteById(id);
    }
}
