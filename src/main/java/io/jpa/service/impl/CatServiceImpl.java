package io.jpa.service.impl;

import io.jpa.entity.Cat;
import io.jpa.jpa.CatCrud;
import io.jpa.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("catService")
public class CatServiceImpl implements CatService {
    private CatCrud catCrud;

    @Override
    public Cat add(Cat cat) {
        return catCrud.save(cat);
    }

    @Override
    public Cat delete(long id) {
        Cat catForDelete = getById(id);
        catCrud.delete(catForDelete);
        return catForDelete;
    }

    @Override
    public Cat getById(long id) {
        return catCrud.findById(id);
    }

    @Override
    public List<Cat> getByName(String name) {
        return catCrud.findByName(name);
    }

    @Override
    public List<Cat> getAllCats() {
        return catCrud.findAll();
    }

    @Autowired
    public void setCatCrud(CatCrud catCrud) {
        this.catCrud = catCrud;
    }
}