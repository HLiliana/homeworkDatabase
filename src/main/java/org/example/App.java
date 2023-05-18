package org.example;

import java.sql.SQLException;
import java.util.Arrays;

/**
 * DESCRIPTION
 * <p>
 * define a database for a booking application that should contain the following tables //bookingApplication
 * accommodation with the following columns //table accommodation
 * -- id: int (primary key) - can also be bigint or uuid // id
 * -- type: varchar(32) // accommodationType
 * -- bed_type: varchar(32) // bedType
 * -- max_guests: int // maxGuests
 * -- description: varchar(512) // description
 * <p>
 * room_fair with the following columns // table room_fair
 * -- id: int (primary key) // id
 * -- value: double // roomValue
 * -- season: varchar(32) // season
 * <p>
 * accommodation_room_fair_relation with the following columns // table accommodation_room_fair_relation
 * -- id: int (primary key)
 * -- accommodation_id: int (foreign key of accommodation)
 * -- room_fair_id: int (foreign key of room_fair)
 * <p>
 * write a test which inserts (INSERT INTO...) data in the tables using the PreparedStatement //test , insert, PreparedStatement
 * and keep into consideration the connection(s) contained in the accommodation_room_fair_relation table
 * write a unit test which interrogates the database (SELECT * FROM...) and
// * print out (in the console) the prices for each room in the database. // printPricesForEachRoom
// * <p>
// * NOTES
// * respect the table and column names and the data types
// * the "accommodation_room_fair_relation" is a connection table between the rooms
// * and the prices; and you will have to use JOIN the interrogation queries
// * for inserting in the database, using Java, I would recommend using PreparedStatement.executeUpdate(...)
// */
public class App {
    public static void main(String[] args) throws SQLException {

        InsertDatabase insertAccommodation = new InsertDatabase();
        insertAccommodation.insertDataIntoAccommodationTable(Arrays.asList(
                new Accommodation(1, "Hotel", "Double", 2, "Spacious room with a double bed"),
                new Accommodation(2, "Apartment", "Single", 4, "Cozy studio apartment for solo travelers"),
                new Accommodation(3, "Villa", "King", 4, "Luxurious villa with private pool"),
                new Accommodation(4, "Guesthouse", "Double", 2, "Comfortable twin room with shared bathroom"),
                new Accommodation(5, "Resort", "Queen", 3, "Beautiful resort suite overlooking the beach")));
//        ReadDatabase accommodation = new ReadDatabase();
//        accommodation.readAccommodationTable();

        InsertDatabase insertRoomFair = new InsertDatabase();
        insertRoomFair.insertDataIntoRoomFairTable(Arrays.asList(
                new RoomFair(1, 100.55, "Summer"),
                new RoomFair(2, 80.55, "Spring"),
                new RoomFair(3, 90.55, "Winter"),
                new RoomFair(4, 90.55, "Autumn")));
//        ReadDatabase roomFair = new ReadDatabase();
//        roomFair.readRoomFairTable();

        InsertDatabase insertAccommodationRoomFairRelation = new InsertDatabase();
        insertAccommodationRoomFairRelation.insertDataIntoAccommodationRoomFairRelationTable(Arrays.asList(
                new AccommodationRoomFairRelation(1,2,4),
                new AccommodationRoomFairRelation(2,1,4),
                new AccommodationRoomFairRelation(3,2,4),
                new AccommodationRoomFairRelation(4,2,3),
                new AccommodationRoomFairRelation(5,3,4),
                new AccommodationRoomFairRelation(6,2,2)
        ));

        insertAccommodationRoomFairRelation.printPricesForEachRoom();

    }

}

