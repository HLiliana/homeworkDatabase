package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReadDatabase {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/accommodationdb";
    static final String USER = "postgres";
    static final String PASS = "root";
    Connection conn = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public void readAccommodationTable(){
            try {
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        String sql = "SELECT id, type, bed_type, max_guests, description FROM accommodation";
        preparedStatement = conn.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();

        List<Accommodation> accommodationList = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String type = resultSet.getString("type");
            String bedType = resultSet.getString("bed_type");
            int MAX_GUEST = resultSet.getInt("max_guests");
            String description = resultSet.getString("description");

            Accommodation accommodation = new Accommodation(id, type,bedType, MAX_GUEST, description);

            accommodationList.add(accommodation);
        }
        accommodationList.forEach(accommodation -> {
            System.out.println("Accommodation ID: " + accommodation.getId());
            System.out.println("Type: " + accommodation.getType());
            System.out.println("Bed Type: " + accommodation.getBedType());
            System.out.println("Max Guests: " + accommodation.getMAX_GUEST());
            System.out.println("Description: " + accommodation.getDescription());
            System.out.println();
        });

        resultSet.close();
        preparedStatement.close();
        conn.close();
    } catch (
    SQLException sqlException1) {
        sqlException1.printStackTrace();
    } catch (Exception exception) {
        exception.printStackTrace();
    } finally {
        try {
            if (resultSet != null)
                resultSet.close();
        } catch (SQLException sqlException2) {
            sqlException2.printStackTrace();
        }
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException sqlException3) {
            sqlException3.printStackTrace();
        }
    }
            System.out.println("Good job for accommodation table!");
}
    public void readRoomFairTable(){

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "SELECT id, value, season FROM room_fair";
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            List<RoomFair> roomFairList = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                double value = resultSet.getDouble("value");
                String season = resultSet.getString("season");
                RoomFair roomFair = new RoomFair(id, value, season);

                roomFairList.add(roomFair);
            }
            roomFairList.forEach(roomFair -> {
                System.out.println("Room fair ID: " + roomFair.getId());
                System.out.println("Value: " + roomFair.getValue());
                System.out.println("Season: " + roomFair.getSeason());

                System.out.println();
            });

            resultSet.close();
            preparedStatement.close();
            conn.close();
        } catch (
                SQLException sqlException1) {
            sqlException1.printStackTrace();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException sqlException2) {
                sqlException2.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException sqlException3) {
                sqlException3.printStackTrace();
            }
        }
        System.out.println("Good job for room fair table!");
    }
}
