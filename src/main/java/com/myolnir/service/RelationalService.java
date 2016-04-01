package com.myolnir.service;

import com.myolnir.model.RelationalObject;
import com.myolnir.repository.RelationalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationalService {

    @Autowired
    private RelationalRepository repository;

    public void save (RelationalObject object) {
        repository.save(object);
    }
}
