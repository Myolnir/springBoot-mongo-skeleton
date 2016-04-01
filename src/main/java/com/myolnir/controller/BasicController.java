package com.myolnir.controller;

import com.myolnir.dto.ObjectDto;
import com.myolnir.model.ObjectToSave;
import com.myolnir.service.BasicMongoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/basicController")
public class BasicController {

    @Autowired
    private BasicMongoService mongoService;

    @RequestMapping (value = "/insertObject", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus (HttpStatus.OK)
    public void insertObjectToBD (@RequestBody ObjectDto object) {
        ObjectToSave objectToSave = new ObjectToSave();
        objectToSave.setId(object.getId());
        objectToSave.setFoo(object.getFoo());
        mongoService.save(objectToSave);
    }

    @RequestMapping (value = "/getObject/{id}", method = RequestMethod.GET)
    @ResponseStatus (HttpStatus.OK)
    public ObjectDto getObjectToBD (@PathVariable String id) {
        ObjectToSave objectToSave = mongoService.findOne(id);
        return new ObjectDto(objectToSave.getId(), objectToSave.getFoo());
    }
}
