package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.Player;
import com.worldnavigator.maze.room.RoomSideVisitor;
import com.worldnavigator.maze.room.*;
import com.worldnavigator.maze.items.Flashlight;
import com.worldnavigator.maze.items.Item;

import java.util.Map;

public class LookCommand implements Command {

    private final Player player;
    private final Output output;

    public LookCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Room room = player.current();
        RoomSide side = room.getSide(player.getDirection());
        Map<String, Item> items = player.getItems();

        if(room.isLit()
                || (items.containsKey("flashlight")
                && ((Flashlight) items.get("flashlight")).isOn())
        ) {
            side.accept(new LookVisitor());
        } else {
            output.println("The room is dark!");
        }
    }

    @Override
    public String name() {
        return "look";
    }

    @Override
    public String description() {
        return "Gives a description of whats in front of the player";
    }

    private class LookVisitor implements RoomSideVisitor {

        @Override
        public void execute(Mirror mirror) {
            output.println("You See a silhouette of you");
        }

        @Override
        public void execute(Painting painting) {
            output.println("Painting");
        }

        @Override
        public void execute(Chest chest) {
            output.println("Chest");
        }

        @Override
        public void execute(Door door) {
            output.println("Door");
        }

        @Override
        public void execute(Seller seller) {
            output.println("Seller");
        }

        @Override
        public void execute(Wall wall) {
            output.println("Wall");
        }
    }
}
