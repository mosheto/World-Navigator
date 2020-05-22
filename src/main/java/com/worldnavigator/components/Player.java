package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.worldnavigator.components.items.Item;

import java.io.IOException;
import java.util.*;

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

    /**
     *
     * @param item To be added to the player items
     * @return if the item wasn't with player.
     */
    public boolean addItem(Item item) {
        return items.putIfAbsent(item.toString(), item) == null;
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
