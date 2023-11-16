package com.dmadev.springJPAHiber.services;
import com.dmadev.springJPAHiber.models.IdenticalCode;
import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.repositories.IdenticalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class IdenticalService {
    private final IdenticalRepository identicalRepository;

    @Autowired
    public IdenticalService(IdenticalRepository identicalRepository) {
        this.identicalRepository = identicalRepository;
    }
      /*мы не можем напрямую вызывать из репы
    - мы должны вызывать внутри хибер транзакции, транзакциями в том числе занимается сервис
    также внутри методов содержится бизнес логика
    например вызываются методы из нескольких репо
     */

    public List<IdenticalCode> findByCodeNumber(Integer codeNumber){
        return identicalRepository.findByCodeNumber(codeNumber);
    }

    public List<IdenticalCode> findByPerson(Person person){
        return identicalRepository.findByPerson(person);
    }





}
