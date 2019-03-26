package io.jpa.controller;

import io.jpa.entity.Cat;
import io.jpa.service.CatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cats")
public class CatController {
    private CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cat addCat(@RequestBody Cat cat) {
        return catService.add(cat);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cat deleteCat(@PathVariable("id") long id) {
        return catService.delete(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Cat> getCatByName(@PathVariable("name") String name) {
        return catService.getByName(name);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Cat getCatById(@PathVariable("id") long id) {
        return catService.getById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }
}
