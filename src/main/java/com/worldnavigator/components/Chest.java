package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.components.items.Item;
import com.worldnavigator.components.items.Key;

import java.util.List;
import java.util.Objects;

public class Chest extends RoomSide implements Openable, Stash {
    private Key key;
    private boolean isOpen;
    private boolean isUnlocked;

    private int gold;
    private List<Item> items;
    private boolean isCollected;

    @JsonCreator
    public Chest(
            @JsonProperty("key") Key key,
            @JsonProperty("open") boolean isOpen,
            @JsonProperty("unlocked") boolean isUnlocked,
            @JsonProperty("gold") int gold,
            @JsonProperty("items") List<Item> items
    ) {
        this.key = key;
        this.isOpen = isOpen;
        this.isUnlocked = isUnlocked;

        this.gold = gold;
        this.items = items;
        this.isCollected = false;
    }

    @Override
    public void open() {
        if(isUnlocked())
            isOpen = true;
    }

    @Override
    public void unlock(Item key) {
        if(Objects.equals(this.key, key))
            isUnlocked = true;
    }

    @Override
    public List<Item> collect() {
        isCollected = true;
        return items;
    }

    @Override
    @JsonIgnore
    public boolean isCollected() {
        return isCollected;
    }

    @Override
    @JsonGetter("key")
    public Item getKey() {
        return key;
    }

    @Override
    @JsonProperty("open")
    public boolean isOpen() {
        return isOpen;
    }

    @Override
    @JsonProperty("unlocked")
    public boolean isUnlocked() {
        return isUnlocked;
    }

    @JsonGetter("gold")
    public int getGold() {
        return gold;
    }

    @JsonGetter("items")
    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Chest";
    }
}
