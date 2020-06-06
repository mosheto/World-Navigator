package com.worldnavigator.maze.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.worldnavigator.maze.items.Key;

public class Painting extends RoomSide {

    private final Key key;
    private boolean isCollected;

    @JsonCreator
    public Painting(
            @JsonProperty("key") Key key
    ) {
        this.key = key;
        this.isCollected = false;
    }

    @Override
    public void accept(RoomSideVisitor visitor) {
        visitor.execute(this);
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    public Key getKey() {
        return key;
    }

    @JsonIgnore
    public boolean isCollected() {
        return isCollected;
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
