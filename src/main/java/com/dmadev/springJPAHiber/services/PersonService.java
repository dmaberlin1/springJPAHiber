package com.dmadev.springJPAHiber.services;

import com.dmadev.springJPAHiber.models.Gender;
import com.dmadev.springJPAHiber.models.Lang;
import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class PersonService {
    /*мы не можем напрямую вызывать из репы
      - мы должны вызывать внутри хибер транзакции, транзакциями в том числе занимается сервис
       */
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void test() {
        System.out.println("Testing here with debug. Inside Hibernate Transaction");
    }


    public List<Person> findByGender(Gender gender) {
        return personRepository.findByGender(gender);
    }

    public List<Person> findByAge(Integer age) {
        return personRepository.findByAge(age);
    }

    public List<Person> findByNameOrderByAge(String name) {
        return personRepository.findByNameOrderByAge(name);
    }

    public List<Person> findByLanguage(Lang language) {
        return personRepository.findByLanguage(language);
    }

    public List<Person> findByEmail(String email) {
        return personRepository.findByEmail(email);
    }

    public List<Person> findByNameStartingWith(String startingWith) {
        return personRepository.findByNameStartingWith(startingWith);
    }

    public List<Person> findByNameOrEmail(String name, String email) {
        return personRepository.findByNameOrEmail(name, email);
    }

    //репозиторий автоматически сгенерирует метод findAll, которыый вернёт все сущности из табл.
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    //указали в параметрах репо Integer , и репо знает что айди целое число
    public Person findOne(int id) {
        Optional<Person> byId = personRepository.findById(id);

        return byId.orElse(null);
    }

    // пометили транзакцией, для того чтобы был дефолт readonly=false
    @Transactional(readOnly = false)
    public void save(Person person) {
        personRepository.save(person);
    }

    // пометили транзакцией, для того чтобы был дефолт readonly=false
    @Transactional
    public void update(int id, Person updatedPerson) {
        updatedPerson.setId(id);
        personRepository.save(updatedPerson);
        //для обновления и сохранения в репе используется один метод
        //метод сейв увидит что передается человек который уже есть в таблице, и потолму этого человека не будет сохранять,
        // а обновит значение у существующего человека
        //поэтому именно этому человеку в качестве сеттера указали айди ,чтобы метод сейв понимал что в этой таблице уже есть человек с таким айди
//        и не нужно создавать, а просто обновить
    }

    @Transactional
    public void delete(int id) {
        personRepository.deleteById(id);
    }

}
