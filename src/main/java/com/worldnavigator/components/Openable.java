package com.worldnavigator.components;

import com.worldnavigator.components.items.Item;

public interface Openable {

    void open();

    boolean isOpen();

    boolean lock(Item key);

    boolean unlock(Item key);

    boolean isUnlocked();

    Item getKey();
}
