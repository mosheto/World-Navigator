package com.worldnavigator.maze;

import com.worldnavigator.maze.room.*;

public interface RoomSideVisitor {

    void execute(Mirror mirror);

    void execute(Painting painting);

    void execute(Chest chest);

    void execute(Door door);

    void execute(Seller seller);

    void execute(Wall wall);
}
