package com.myolnir.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.myolnir.SpringBootMongoApplication;
import com.myolnir.TestUtils;
import com.myolnir.model.ObjectToSave;
import com.myolnir.service.BasicMongoService;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith (SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration (classes = { SpringBootMongoApplication.class })
public class BasicControllerTest extends TestUtils {

    @InjectMocks
    private BasicController basicController;

    @Mock
    private BasicMongoService basicService;

    @Value ("classpath:/objectToInsert.json")
    private Resource objectToInsertResource;

    private MockMvc mockMvc;

    @Before
    public void init () {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(
              basicController)
              .build();
    }

    @Test
    public void insertANewObjectIntoDBThenInsertsOK () throws Exception {
        doNothing().when(basicService).save(any(ObjectToSave.class));
        String objectRequestJson = FileUtils.readFileToString(objectToInsertResource.getFile());
        mockMvc
              .perform(post("/api/basicController/insertObject")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectRequestJson))
              .andExpect(status().isOk());
    }

    @Test
    public void get_an_object_from_DB_returns_correct_object () throws Exception {
        when(basicService.findOne(anyString())).thenReturn(TestUtils.createBasicObject());
        mockMvc
              .perform(get("/api/basicController/getObject/1")
              ).andExpect(status().isOk());
    }
}
