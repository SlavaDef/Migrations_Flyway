package ItGoHomwork.com.Servise;

import ItGoHomwork.com.DatabazV2.Database;
import org.flywaydb.core.Flyway;

import java.io.IOException;

public class DataBazeInitServiceV2 {

    public static final String DB_URL = "jdbc:h2:./test";

    public void initDB(Database database) throws IOException {
        Flyway flyway = Flyway.configure().
                dataSource(DB_URL, null, null)
                .load();
        flyway.migrate();
    }
}
