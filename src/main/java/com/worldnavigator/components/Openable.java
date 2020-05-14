package com.worldnavigator.components;

import com.worldnavigator.components.items.Item;

public interface Openable {

    void open();

    void unlock(Item key);

    boolean isOpen();

    boolean isUnlocked();

    Item getKey();
}
