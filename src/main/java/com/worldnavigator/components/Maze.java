package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Maze {
    private int time;
    private int winningRoom;
    private List<Room> rooms;

    @JsonCreator
    public Maze(
            @JsonProperty("rooms") List<Room> rooms
    ) {
        this.rooms = rooms;
    }

    public Room getRoom(int idx) {
        return rooms.get(idx);
    }

    @JsonGetter("rooms")
    public List<Room> getRooms() {
        return rooms;
    }
}
