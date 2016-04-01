package com.myolnir.service;

import com.myolnir.TestUtils;
import org.junit.Before;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class RelationalServiceTest extends TestUtils {

    private EmbeddedDatabase db;

    @Before
    public void setUp () {
        db = new EmbeddedDatabaseBuilder()
              .setType(EmbeddedDatabaseType.H2)
              .addScript("db/sql/create-db.sql")
              .addScript("db/sql/insert-data.sql")
              .build();
    }
}
