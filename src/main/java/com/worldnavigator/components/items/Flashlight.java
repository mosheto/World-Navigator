package com.worldnavigator.components.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Flashlight extends Item {
    private boolean isOn;

    @JsonCreator
    public Flashlight() {
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
    }

    public void turnOff() {
        isOn = false;
    }

    @JsonIgnore
    public boolean isOn() {
        return isOn;
    }

    @Override
    public String toString() {
        return "flashlight";
    }
}
