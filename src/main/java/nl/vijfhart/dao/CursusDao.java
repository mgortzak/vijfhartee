package nl.vijfhart.dao;

import nl.vijfhart.model.Cursus;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public enum CursusDao {
    INSTANCE;

    public List<Cursus> findAll(DataSource dataSource) {
        try {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM CURSUS ORDER BY OMSCHRIJVING");

                List<Cursus> cursusList = new ArrayList<>();
                while (resultSet.next()) {
                    Cursus cursus = new Cursus();
                    cursus.setId(resultSet.getInt("id"));
                    cursus.setNaam(resultSet.getString("naam"));
                    cursus.setOmschrijving(resultSet.getString("omschrijving"));
                    cursus.setDuur(resultSet.getInt("duur"));
                    cursus.setPrijs(resultSet.getInt("prijs"));

                    cursusList.add(cursus);
                }

                return cursusList;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return new ArrayList<>();
        }
    }

    public int insert(DataSource dataSource, Cursus cursus) {
        try {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                statement.executeUpdate(
                        "INSERT INTO CURSUS VALUES (DEFAULT, " + cursus.getDuur() + ", '" + cursus.getNaam() + "', '" + cursus.getOmschrijving() + "', " + cursus.getPrijs() + ")",
                        Statement.RETURN_GENERATED_KEYS
                ); // TODO jaja, sql injection ftw!

                ResultSet keys = statement.getGeneratedKeys();
                if (keys.next()) {
                    return keys.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }


    public Cursus get(DataSource dataSource, int id) {
        try {
            try (Connection connection = dataSource.getConnection();
                 Statement statement = connection.createStatement()) {

                ResultSet resultSet = statement.executeQuery("SELECT * FROM CURSUS WHERE ID = " + id); // TODO jaja, sql injection ftw!

                if (resultSet.next()) {
                    Cursus cursus = new Cursus();
                    cursus.setId(resultSet.getInt("id"));
                    cursus.setNaam(resultSet.getString("naam"));
                    cursus.setOmschrijving(resultSet.getString("omschrijving"));
                    cursus.setDuur(resultSet.getInt("duur"));
                    cursus.setPrijs(resultSet.getInt("prijs"));

                    return cursus;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(System.err);
            return null;
        }
    }
}
