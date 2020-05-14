package com.worldnavigator.components;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Room {
    private boolean isLit;
    private boolean hasLights;

    Map<Direction, RoomSide> sides;

    @JsonCreator
    public Room(
            @JsonProperty("lit") boolean isLit,
            @JsonProperty("hasLights") boolean hasLights,
            @JsonProperty("sides") Map<Direction, RoomSide> sides
    ) {
        this.sides = sides;
        this.isLit = isLit;
        this.hasLights = hasLights;
    }

    public void switchLights() {
        if(hasLights)
            isLit = !isLit;
    }

    public RoomSide getSide(Direction dir) {
        return this.sides.get(dir);
    }

    @JsonGetter("lit")
    public boolean isLit() {
        return isLit;
    }

    @JsonGetter("hasLights")
    public boolean hasLights() {
        return hasLights;
    }

    @JsonGetter("sides")
    public Map<Direction, RoomSide> getSides() {
        return sides;
    }
}
