package com.worldnavigator.maze.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;


public class Flashlight extends Item {
    private boolean isOn;

    @JsonCreator
    public Flashlight() {
        this.isOn = false;
    }

    @Override
    public void accept(ItemVisitor visitor) {
        visitor.execute(this);
    }

    public void setOn(boolean isOn) {
        this.isOn = isOn;
    }

    @JsonIgnore
    public boolean isOn() {
        return isOn;
    }

    /**
     *
     * @return the string "flashlight" as all instances of this class
     *         are equal.
     */
    @Override
    public String toString() {
        return "flashlight";
    }
}
