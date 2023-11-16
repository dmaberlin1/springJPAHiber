//package com.dmadev.springJPAHiber.dao;
//
//import com.dmadev.springHiber.models.Person;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Component
//public class PersonDAO {
//
//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public PersonDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    //    import org.springframework.transaction.annotation.Transactional;
//    @Transactional(readOnly = true)
//    public List<Person> index(){
//        Session session = sessionFactory.getCurrentSession();
//        //обычный хибер код
//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//        return people;
//    }
//
//    @Transactional(readOnly = true)
//    public Person show(int id){
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.get(Person.class,id);
//    }
//
//    @Transactional
//    public void save(Person person){
//        Session session = sessionFactory.getCurrentSession();
//        session.save(person);
//    }
//
//    @Transactional
//    public void update(int id, Person updatedPerson){
//        Session session = sessionFactory.getCurrentSession();
////        персона для обновления
//        Person personToBeUpdated = session.get(Person.class, id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
//        personToBeUpdated.setGender(updatedPerson.getGender());
//        personToBeUpdated.setLanguage(updatedPerson.getLanguage());
//        personToBeUpdated.setCars(updatedPerson.getCars());
//        personToBeUpdated.setIdenticalCode(updatedPerson.getIdenticalCode());
//    }
//
//    @Transactional
//    public void delete(int id){
//        Session session = sessionFactory.getCurrentSession();
//        session.remove(session.get(Person.class,id));
//        //remove\delete синонимы
//    }
//
//}
