package com.dmadev.springJPAHiber.repositories;

import com.dmadev.springJPAHiber.models.Item;
import com.dmadev.springJPAHiber.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByItemName(String itemName);

    //person.getItems
    List<Item> findByOwner(Person owner);



}
