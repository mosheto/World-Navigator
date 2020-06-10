package com.worldnavigator.maze.room;

import com.worldnavigator.maze.items.Item;

import java.util.Optional;

public interface HiddenItem {

    Optional<Item> getItem();

    void setCollected(boolean collected);

    boolean isCollected();
}
