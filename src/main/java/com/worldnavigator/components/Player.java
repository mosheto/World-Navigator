package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.components.items.Item;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Player {
    // Possessions
    private int gold;
    private Map<String, Item> items;

    // Location
    private int room;
    private Direction direction;

    @JsonCreator
    public Player(
            @JsonProperty("gold") int gold,
            @JsonProperty("items") Map<String, Item> items,
            @JsonProperty("room") int room,
            @JsonProperty("direction") Direction direction
    ) {
        this.gold = gold;
        this.items = items;

        this.room = room;
        this.direction = direction;
    }

    public void setGold(int amount) {
        gold = amount;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @JsonGetter("gold")
    public int getGold() {
        return gold;
    }

    @JsonGetter("items")
    public Map<String, Item> getItems() {
        return items;
    }

    @JsonGetter("room")
    public int getRoom() {
        return room;
    }

    @JsonGetter("direction")
    public Direction getDirection() {
        return direction;
    }
}
