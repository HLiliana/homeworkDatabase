package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InsertDatabaseTest {

    @Test
    void testInsertDataIntoAccommodationTable() {
        // given
        Accommodation accommodation1 = new Accommodation(6, "Apartment", "Single Bed", 1, "Cozy single room");
        Accommodation accommodation2 = new Accommodation(7, "Villa", "Double Bed", 2, "Spacious double room");
        List<Accommodation> accommodationList = new ArrayList<>();
        accommodationList.add(accommodation1);
        accommodationList.add(accommodation2);
        //when
        InsertDatabase testInsertDatabase = new InsertDatabase();
        testInsertDatabase.insertDataIntoAccommodationTable(accommodationList);
        // then
        Assertions.assertDoesNotThrow(() -> testInsertDatabase.insertDataIntoAccommodationTable(accommodationList));
    }

    @Test
    void insertDataIntoRoomFairTable() {
        // given
        RoomFair roomFair1 = new RoomFair(5, 120.55, "Winter");
        RoomFair roomFair2 = new RoomFair(6, 140.55, "Autumn");
        List<RoomFair> roomFairList = new ArrayList<>();
        roomFairList.add(roomFair1);
        roomFairList.add(roomFair2);
        //when
        InsertDatabase testInsertDatabase = new InsertDatabase();
        testInsertDatabase.insertDataIntoRoomFairTable(roomFairList);
        // then
        Assertions.assertDoesNotThrow(() -> testInsertDatabase.insertDataIntoRoomFairTable(roomFairList));
    }

    @Test
    void insertDataIntoAccommodationRoomFairRelationTable() throws SQLException {
        //given
        AccommodationRoomFairRelation accommodationRoomFairRelation1=
                new AccommodationRoomFairRelation(7,6,4);
        AccommodationRoomFairRelation accommodationRoomFairRelation2=
                new AccommodationRoomFairRelation(8,7,4);
        List<AccommodationRoomFairRelation> accommodationRoomFairRelationList =  new ArrayList<>();
        accommodationRoomFairRelationList.add(accommodationRoomFairRelation1);
        accommodationRoomFairRelationList.add(accommodationRoomFairRelation2);
        //when
        InsertDatabase testInsertAccommodationRoomFairRelation = new InsertDatabase();
        testInsertAccommodationRoomFairRelation.insertDataIntoAccommodationRoomFairRelationTable
                (accommodationRoomFairRelationList);
        //then
        Assertions.assertDoesNotThrow(() -> testInsertAccommodationRoomFairRelation.
                insertDataIntoAccommodationRoomFairRelationTable(accommodationRoomFairRelationList));
    }
    @Test
    void printPricesForEachRoom() throws SQLException {
        //given
        AccommodationRoomFairRelation accommodationRoomFairRelation1=
                new AccommodationRoomFairRelation(11,5,4);
        AccommodationRoomFairRelation accommodationRoomFairRelation2=
                new AccommodationRoomFairRelation(12,5,5);
        List<AccommodationRoomFairRelation> accommodationRoomFairRelationList =  new ArrayList<>();
        accommodationRoomFairRelationList.add(accommodationRoomFairRelation1);
        accommodationRoomFairRelationList.add(accommodationRoomFairRelation2);
        //when
        InsertDatabase testPricesForEachRoom = new InsertDatabase();
        testPricesForEachRoom.printPricesForEachRoom();
        //then
        Assertions.assertDoesNotThrow(()-> testPricesForEachRoom.printPricesForEachRoom());


    }
}





