package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.components.items.Item;
import com.worldnavigator.components.items.Key;

import java.util.Objects;

public class Door extends RoomSide implements Openable {
    private Key key;
    private boolean isOpen;
    private boolean isUnlocked;

    private int nextRoom;

//    @JsonCreator
//    public Door(
//            @JsonProperty("nextRoom") int nextRoom
//    ) {
//        this.key = null;
//        this.isOpen = false;
//        this.isUnlocked = false;
//        this.nextRoom = nextRoom;
//    }

    @JsonCreator
    public Door(
            @JsonProperty("key") Key key,
            @JsonProperty("nextRoom") int nextRoom,
            @JsonProperty("isOpen") boolean isOpen,
            @JsonProperty("isUnlocked") boolean isUnlocked
    ) {
        this.key = key;
        this.isOpen = isOpen;
        this.isUnlocked = isUnlocked;
        this.nextRoom = nextRoom;
    }

    @Override
    public void unlock(Item key) {
        if(Objects.equals(this.key, key))
            isUnlocked = true;
    }

    @Override
    public void open() {
        if(isUnlocked())
            isOpen = true;
    }

    @Override
    @JsonGetter("open")
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    @JsonGetter("isUnlocked")
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @JsonGetter("nextRoom")
    public int getNextRoom() {
        return nextRoom;
    }

    @Override
    @JsonGetter("key")
    public Item getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "Door";
    }
}
