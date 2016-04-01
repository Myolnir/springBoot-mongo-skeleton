package com.myolnir.service;

import static org.mockito.Mockito.*;

import com.myolnir.model.ObjectToSave;
import com.myolnir.repository.BasicMongoRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BasicMongoServiceTest {

    @InjectMocks
    private BasicMongoService basicMongoService;

    @Mock
    private BasicMongoRepository basicMongoRepository;

    @Before
    public void init () {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void when_service_called_then_object_is_stored_in_DB () {
        ObjectToSave objectToSave = new ObjectToSave();
        objectToSave.setId("id");
        objectToSave.setFoo("foo");
        when(basicMongoRepository.save(objectToSave)).thenReturn(new ObjectToSave());

        basicMongoService.save(objectToSave);

        verify(basicMongoRepository, times(1)).save(objectToSave);
    }

    @Test
    public void when_service_called_to_find_object_then_object_is_returned_from_DB () {
        ObjectToSave returnObject = new ObjectToSave();
        returnObject.setId("1");
        returnObject.setFoo("foo");
        when(basicMongoRepository.findOne(anyString())).thenReturn(returnObject);
        basicMongoService.findOne("1");

        verify(basicMongoRepository, times(1)).findOne("1");
    }
}
