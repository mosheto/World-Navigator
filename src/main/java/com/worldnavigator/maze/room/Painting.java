package com.worldnavigator.maze.room;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.worldnavigator.maze.items.Item;

import java.util.Optional;

public final class Painting extends RoomSide implements HiddenItem {

    private final Item item;
    private boolean isCollected;

    @JsonCreator
    public Painting(
            @JsonProperty("item") Item item
    ) {
        this.item = item;
        this.isCollected = false;
    }

    @Override
    public void accept(RoomSideVisitor visitor) {
        visitor.execute(this);
    }

    @Override
    public Optional<Item> getItem() {
        return Optional.ofNullable(item);
    }

    @Override
    public void setCollected(boolean collected) {
        isCollected = collected;
    }

    @Override
    public boolean isCollected() {
        return isCollected;
    }

    @Override
    public String toString() {
        return "Painting";
    }
}
