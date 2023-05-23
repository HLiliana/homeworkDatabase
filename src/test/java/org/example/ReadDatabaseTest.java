package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadDatabaseTest {

    @Test
    void testingReadAccommodationTable() {
        //given
        ReadDatabase readDatabase = new ReadDatabase();
        //when
        readDatabase.readAccommodationTable();
        //then
    }

    @Test
    void testingReadRoomFairTable() {
        //given
        ReadDatabase readDatabase = new ReadDatabase();
        //when
        readDatabase.readRoomFairTable();
        //then
    }
}