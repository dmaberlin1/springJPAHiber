//package com.dmadev.springJPAHiber.dao;
//
//import com.dmadev.springHiber.models.Car;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Component
//
//public class CarDAO {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public CarDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    @Transactional(readOnly = true)
//    public List<Car> index(){
//        Session session = sessionFactory.getCurrentSession();
//
//        List<Car> carList = session.createQuery("select c from Car c", Car.class).getResultList();
//        return carList;
//    }
//
//    public Car show(int id){
//        Session session = sessionFactory.getCurrentSession();
//        Car car = session.get(Car.class, id);
//        return car;
//    }
//
//    public void save(Car car){
//        Session session = sessionFactory.getCurrentSession();
//        session.save(car);
//    }
//
//    public void update(int id,Car updatedCar){
//        Session session = sessionFactory.getCurrentSession();
//        Car carToBeUpdated = session.get(Car.class, id);
//         carToBeUpdated.setColor(updatedCar.getColor());
//         carToBeUpdated.setElectric(updatedCar.getElectric());
//         carToBeUpdated.setEngineCapacity(updatedCar.getEngineCapacity());
//         carToBeUpdated.setColor(updatedCar.getColor());
//         carToBeUpdated.setModel(updatedCar.getModel());
//         carToBeUpdated.setOwner(updatedCar.getOwner());
//         carToBeUpdated.setTypeBody(updatedCar.getTypeBody());
//    }
//
//}
