package org.example;

import java.sql.*;
import java.util.List;

public class InsertDatabase {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/accommodationdb";
    static final String USER = "postgres";
    static final String PASS = "root";

    public void insertDataIntoAccommodationTable(List<Accommodation> accommodationList) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) " +
                    "VALUES (?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            accommodationList.forEach(accommodation -> {
                try {
                    preparedStatement.setInt(1, accommodation.getId());
                    preparedStatement.setString(2, accommodation.getType());
                    preparedStatement.setString(3, accommodation.getBedType());
                    preparedStatement.setInt(4, accommodation.getMAX_GUEST());
                    preparedStatement.setString(5, accommodation.getDescription());
                    preparedStatement.executeUpdate();

                    System.out.println("Successfully inserted:");
                    System.out.println("ID: " + accommodation.getId() +
                            " Type: " + accommodation.getType() +
                            " Bed type: " + accommodation.getBedType() +
                            " Max guests: " + accommodation.getMAX_GUEST() +
                            " Description: " + accommodation.getDescription());
                    System.out.println();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            });

        } catch (SQLException sglException) {
            throw new RuntimeException(sglException);
        }
    }

    public void insertDataIntoRoomFairTable(List<RoomFair> roomFairList) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO room_fair (id, value, season) " +
                    "VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            roomFairList.forEach(roomFair -> {
                try {
                    preparedStatement.setInt(1, roomFair.getId());
                    preparedStatement.setDouble(2, roomFair.getValue());
                    preparedStatement.setString(3, roomFair.getSeason());
                    preparedStatement.executeUpdate();

                    System.out.println("Successfully inserted:");
                    System.out.println("ID: " + roomFair.getId() +
                            " Value: " + roomFair.getValue() +
                            " Season: " + roomFair.getSeason());
                    System.out.println();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            });
        } catch (SQLException sglException) {
            throw new RuntimeException(sglException);
        }
    }

    public void insertDataIntoAccommodationRoomFairRelationTable(List<AccommodationRoomFairRelation> accommodationRoomFairRelationList) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            String sql = "INSERT INTO accommodation_room_fair_relation"
                    + "(id, accommodation_id, room_fair_id) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = null;
            accommodationRoomFairRelationList.forEach(accommodationRoomFairRelation -> {
                try {
                    preparedStatement.setInt(1, accommodationRoomFairRelation.getId());
                    preparedStatement.setInt(2, accommodationRoomFairRelation.getAccommodationId());
                    preparedStatement.setInt(3, accommodationRoomFairRelation.getRoomFairId());
                    preparedStatement.executeUpdate();

                    System.out.println("Successfully inserted:");
                    System.out.println("ID: " + accommodationRoomFairRelation.getId() +
                            " Accommodation id: " + accommodationRoomFairRelation.getAccommodationId() +
                            " Room fair id: " + accommodationRoomFairRelation.getRoomFairId());
                    System.out.println();
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
            });
        } catch (SQLException sglException) {
            throw new RuntimeException(sglException);
        }
    }

    public void printPricesForEachRoom() throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT accommodation.id, accommodation.type,accommodation.bed_type, room_fair.value \n" +
                            "From accommodation JOIN accommodation_room_fair_relation \n" +
                            "ON accommodation.id = accommodation_room_fair_relation.id \n" +
                            "JOIN room_fair ON accommodation_room_fair_relation.id  = room_fair.id;");

            boolean hasResults = resultSet.next();
            if (hasResults) {

                while (resultSet.next()) {

                    String accommodationType = resultSet.getString("type");
                    String bedType = resultSet.getString("bed_type");
                    double roomPrice = resultSet.getDouble("value");
                    System.out.println("Accommodation: " + accommodationType + " with " + bedType.toLowerCase() +
                            " bed has the price of " + roomPrice + " per night.");
                }
            }
        }catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}

