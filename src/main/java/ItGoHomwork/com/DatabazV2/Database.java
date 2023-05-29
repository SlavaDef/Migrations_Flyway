package ItGoHomwork.com.DatabazV2;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    private static final String url = "jdbc:h2:./test";

    private Connection connection;

    private static final Database INSTANCE = new Database();

    private Database() {

        try {
            connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getUrl() {
        return url;
    }

    public static Database getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

}
