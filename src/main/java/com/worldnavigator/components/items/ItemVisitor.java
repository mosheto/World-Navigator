package com.worldnavigator.components.items;

public interface ItemVisitor {

    void execute(Key key);

    void execute(Flashlight flashlight);
}
