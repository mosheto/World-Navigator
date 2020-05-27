package com.worldnavigator.maze.room;

import com.worldnavigator.maze.items.Item;

public interface Openable {

    void open();

    boolean isOpen();

    boolean lock(Item key);

    boolean unlock(Item key);

    boolean isUnlocked();

    Item getKey();
}
