package com.worldnavigator.components;

import com.worldnavigator.components.items.Item;

import java.util.List;

public interface Stash {

    List<Item> collect();

    boolean isCollected();
}
