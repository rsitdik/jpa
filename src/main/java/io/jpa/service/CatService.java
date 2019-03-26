package io.jpa.service;

import io.jpa.entity.Cat;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CatService {
    Cat add(Cat cat);

    Cat delete(long id);

    Cat getById(long id);

    List<Cat> getByName(String name);

    List<Cat> getAllCats();
}
