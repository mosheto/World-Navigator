package com.worldnavigator.maze.room;

public class Wall extends RoomSide {

    @Override
    public void accept(RoomSideVisitor visitor) {
        visitor.execute(this);
    }

    @Override
    public String toString() {
        return "Wall";
    }
}
