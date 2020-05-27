package com.worldnavigator.maze.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldnavigator.maze.RoomSideVisitor;
import com.worldnavigator.maze.items.Key;

import java.util.List;

public class Mirror extends RoomSide {

    private final Key key;
    private boolean isCollected;

    @JsonCreator
    public Mirror(
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
}
