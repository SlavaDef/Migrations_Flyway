package ItGoHomwork.com.DatabazV2;

import ItGoHomwork.com.ClientAbout.ClientService;

public class App {
    public static void main(String[] args) throws Exception {

        Database database = Database.getInstance();
      //  new DataBazeInitServiceV2().initDB(database);

      ClientService cl =  new ClientService(database.getConnection());
        cl.create("IBM");
        String clientName = cl.getById(2);
        System.out.println(clientName);
        cl.deleteById(2);
        System.out.println(cl.listAll());
    }
}