package com.myolnir;

import com.myolnir.model.ObjectToSave;

public class TestUtils {

    protected static ObjectToSave createBasicObject () {
        ObjectToSave objectToSave = new ObjectToSave();
        objectToSave.setId("id");
        objectToSave.setFoo("foo");
        return objectToSave;
    }
}
