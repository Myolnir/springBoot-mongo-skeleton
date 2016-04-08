package com.myolnir.controller;

import com.myolnir.dto.ObjectDto;
import com.myolnir.model.ObjectToSave;
import com.myolnir.model.RelationalObject;
import com.myolnir.service.BasicMongoService;
import com.myolnir.service.RelationalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/basicController")
public class BasicController {

    @Autowired
    private BasicMongoService mongoService;

    @Autowired
    private RelationalService relationalService;

    @RequestMapping (value = "/insertObject", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus (HttpStatus.OK)
    public void insertObjectToBD (@RequestBody ObjectDto object) {
        ObjectToSave objectToSave = new ObjectToSave();
        objectToSave.setId(object.getId());
        objectToSave.setDescription(object.getDescription());
        RelationalObject relationalObject = new RelationalObject("nombre", "comentarios");
        mongoService.save(objectToSave);
        relationalService.save(relationalObject);
    }

    @RequestMapping (value = "/getObject/{id}", method = RequestMethod.GET)
    @ResponseStatus (HttpStatus.OK)
    public ObjectDto getObjectToBD (@PathVariable String id) {
        ObjectToSave objectToSave = mongoService.findOne(id);
        return new ObjectDto(objectToSave.getId(), objectToSave.getDescription());
    }
}
