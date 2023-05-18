package org.example;

public class AccommodationRoomFairRelation {
    int id;
    int accommodationId;
    int roomFairId;

    public AccommodationRoomFairRelation(int id, int accommodationId, int roomFairId) {
        this.id = id;
        this.accommodationId = accommodationId;
        this.roomFairId = roomFairId;
    }

    public int getId() {
        return id;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public int getRoomFairId() {
        return roomFairId;
    }
}
