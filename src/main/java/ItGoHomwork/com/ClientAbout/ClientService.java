package ItGoHomwork.com.ClientAbout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientService {

    private PreparedStatement createSt;
    private PreparedStatement readNameByIdSt;
    private PreparedStatement deleteSt;
    private PreparedStatement updateSt;
    private PreparedStatement readAllSt;

    public ClientService(Connection connection) {
        try {
            createSt = connection
                    .prepareStatement("INSERT INTO client (name) VALUES (?)");
            readNameByIdSt = connection
                    .prepareStatement("SELECT name FROM client WHERE id = (?)");
            updateSt = connection
                    .prepareStatement("UPDATE client SET name = (?) WHERE ID = (?)");
            deleteSt = connection
                    .prepareStatement("DELETE FROM client WHERE ID = (?)");
            readAllSt = connection
                    .prepareStatement("SELECT * FROM client");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void create(String name) throws Exception {
        if (name.length() < 2 || name.length() > 100) {
            throw new Exception("Wrong length of the name");
        }
        try {
            createSt.setString(1, name);
            createSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String getById(long id) throws Exception {
        if (id == 0) {
            throw new Exception("Zero can not be id");
        }
        String name;
        try {
            readNameByIdSt.setLong(1, id);
            ResultSet rs = readNameByIdSt.executeQuery();
            rs.next();
            name = rs.getString("name");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;

    }

    public void setName(long id, String name) {

        try {
            updateSt.setString(1, name);
            updateSt.setLong(2, id);
            updateSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteById(long id) throws Exception {
        if (id == 0) {
            throw new Exception("Zero can not be id");
        }
        try {
            deleteSt.setLong(1, id);
            deleteSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Client> listAll() throws SQLException {
        Client client;
        List<Client> list = new ArrayList<>();
        try {
            ResultSet rs = readAllSt.executeQuery();

            while (rs.next()) {
                client = new Client();
                client.setName(rs.getString("name"));
                client.setId(rs.getInt("id"));
                list.add(client);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
