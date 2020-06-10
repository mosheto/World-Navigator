package com.worldnavigator.maze.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.worldnavigator.maze.Direction;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public final class Room {
    private boolean isLit;
    private final boolean hasLights;

    @JsonDeserialize(as = EnumMap.class)
    private final Map<Direction, RoomSide> sides;

    @JsonCreator
    public Room(
            @JsonProperty("lit") boolean isLit,
            @JsonProperty("hasLights") boolean hasLights,
            @JsonProperty("sides") Map<Direction, RoomSide> sides
    ) {
        this.isLit = isLit;
        this.hasLights = hasLights;
        this.sides = Objects.requireNonNull(sides);
    }

    public void switchLights() {
        if(hasLights)
            isLit = !isLit;
    }

    public RoomSide getSide(Direction dir) {
        return this.sides.get(dir);
    }

    public boolean isLit() {
        return isLit;
    }

    public boolean hasLights() {
        return hasLights;
    }
}
