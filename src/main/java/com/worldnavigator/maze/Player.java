package com.worldnavigator.maze;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.worldnavigator.maze.items.Item;
import com.worldnavigator.maze.room.Door;
import com.worldnavigator.maze.room.Room;
import com.worldnavigator.maze.room.RoomSide;

import java.util.*;

public class Player {
    private final Maze maze;

    // Possessions
    private int gold;
    private Map<String, Item> items;


    private int location;
    private boolean isDone;
    private Direction direction;


    @JsonCreator
    public Player(
            Maze maze,
            int gold,
            int location,
            Direction direction,
            Map<String, Item> items
    ) {

        this.maze = maze;

        this.gold = gold;
        this.items = items;

        this.isDone = false;
        this.location = location;
        this.direction = direction;
    }

    public void next() {
        if(isDone)
            throw new NoSuchElementException();

        Room room = maze.getRoom(location);
        RoomSide side = room.getSide(direction);

        if(side instanceof Door) {

            Door door = (Door) side;

            if(door.isOpen()) {

                if(door.getNextRoom() >= 0)
                    location = door.getNextRoom();
                else
                    isDone = true;

            } else {
                throw new IllegalStateException();
            }

        } else {
            throw new IllegalStateException();
        }
    }

    public Room current() {
        return maze.getRoom(location);
    }

    public boolean isDone() {
        return isDone;
    }

    @JsonSetter
    public void setGold(int amount) {
        gold = amount;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     *
     * @param item To be added to the player items
     * @return if the item wasn't with player.
     */
    public boolean addItem(Item item) {
        return items.putIfAbsent(item.toString(), item) == null;
    }

    public int getGold() {
        return gold;
    }

    public Map<String, Item> getItems() {
        return Collections.unmodifiableMap(items);
    }

    public Direction getDirection() {
        return direction;
    }
}
