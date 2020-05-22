package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.components.items.Item;

import java.util.List;

public class Painting extends RoomSide implements Stash {

    private List<Item> items;
    private boolean isCollected;

    @JsonCreator
    public Painting(
            @JsonProperty("item") List<Item> items
    ) {
        this.items = items;
        this.isCollected = false;
    }

    @Override
    public void accept(RoomSideVisitor visitor) {
        visitor.execute(this);
    }

    @Override
    public List<Item> collect() {
        isCollected = true;
        return items;
    }

    @JsonGetter("items")
    public List<Item> getItems() {
        return items;
    }

    @Override
    @JsonIgnore
    public boolean isCollected() {
        return isCollected;
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
