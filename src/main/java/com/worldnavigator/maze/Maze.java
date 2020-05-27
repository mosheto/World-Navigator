package com.worldnavigator.maze;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.maze.room.Room;

import java.util.HashMap;
import java.util.List;

public class Maze {
    private final int time;
    private final List<Room> rooms;

    private final int gold;
    private final int location;
    private final Direction direction;

    @JsonCreator
    public Maze(
            @JsonProperty("time") int time,
            @JsonProperty("rooms") List<Room> rooms,

            @JsonProperty("gold") int gold,
            @JsonProperty("location") int location,
            @JsonProperty("direction") Direction direction
    ) {
        this.time = time;
        this.rooms = rooms;

        this.gold = gold;
        this.location = location;
        this.direction = direction;
    }

    public int getTime() {
        return time;
    }

    public Room getRoom(int idx) {
        return rooms.get(idx);
    }

    /**
     *
     * @return new player to navigate the maze.
     */
    public Player player() {
        return new Player(
                this,
                gold,
                location,
                direction,
                new HashMap<>()
        );
    }
}
