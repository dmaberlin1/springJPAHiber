package com.dmadev.springJPAHiber.services;

import com.dmadev.springJPAHiber.models.Item;
import com.dmadev.springJPAHiber.models.Person;
import com.dmadev.springJPAHiber.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)  //всё будет происходить внутри хибер транзакции
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /*мы не можем напрямую вызывать из репы
    - мы должны вызывать внутри хибер транзакции, транзакциями в том числе занимается сервис
    также внутри методов содержится бизнес логика
    например вызываются методы из нескольких репо
     */
    public List<Item>findByItemName(String itemName){
        return itemRepository.findByItemName(itemName);
    }

    public List<Item> findByOwner(Person owner){
        return itemRepository.findByOwner(owner);
    }




}
