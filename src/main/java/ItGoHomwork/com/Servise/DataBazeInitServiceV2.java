package ItGoHomwork.com.Servise;

import ItGoHomwork.com.DatabazV2.Database;
import org.flywaydb.core.Flyway;

import java.io.IOException;

public class DataBazeInitServiceV2 {

    public void initDB(Database database) throws IOException {
        Flyway flyway = Flyway.configure().
                dataSource(database.getUrl(), null, null)
                .load();
        flyway.migrate();
    }
}
