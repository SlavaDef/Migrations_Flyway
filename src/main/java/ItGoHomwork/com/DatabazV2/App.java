package ItGoHomwork.com.DatabazV2;

import ItGoHomwork.com.Servise.DataBazeInitServiceV2;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {

        Database database = Database.getInstance();
        new DataBazeInitServiceV2().initDB(database);
    }
}