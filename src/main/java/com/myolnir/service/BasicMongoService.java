package com.myolnir.service;

import com.myolnir.model.ObjectToSave;
import com.myolnir.repository.BasicMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasicMongoService {

    @Autowired
    private BasicMongoRepository basicMongoRepository;

    public void save (ObjectToSave objectToSave) {
        basicMongoRepository.save(objectToSave);
    }

    public ObjectToSave findOne (String id) {
        return basicMongoRepository.findOne(id);
    }
}
