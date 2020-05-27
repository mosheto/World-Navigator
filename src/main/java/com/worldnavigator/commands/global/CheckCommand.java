package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.*;
import com.worldnavigator.maze.items.Item;
import com.worldnavigator.maze.items.Key;
import com.worldnavigator.maze.room.*;

public class CheckCommand implements Command {

    private final Player player;
    private final Output output;

    public CheckCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        RoomSide side = player
                .current()
                .getSide(player.getDirection());

        side.accept(new CheckVisitor());
    }

    @Override
    public String usage() {
        return "check";
    }

    @Override
    public String description() {
        return "Checks the thing in front of the player.";
    }

    private class CheckVisitor implements RoomSideVisitor {

        @Override
        public void execute(Mirror mirror) {
            Key key = mirror.getKey();

            if(key == null) {
                output.println("There is nothing hidden here!");

            } else {
                if(mirror.isCollected()) {
                    output.println("You already got the hidden key!");

                } else {
                    player.addItem(key);
                    mirror.setCollected(true);
                }
            }
        }

        @Override
        public void execute(Painting painting) {
            Key key = painting.getKey();

            if(key == null) {
                output.println("There is nothing hidden here!");

            } else {
                if(painting.isCollected()) {
                    output.println("You already got the hidden key!");

                } else {
                    player.addItem(key);
                    painting.setCollected(true);
                }
            }
        }

        @Override
        public void execute(Chest chest) {

            if(chest.isOpen()) {

                if(chest.isCollected()) {
                    output.println("The chest contents are already collected!");

                } else {

                    output.println(String.format("You got %d gold from this chest!", chest.getGold()));
                    player.setGold(player.getGold() + chest.getGold());

                    output.println("The items you acquired from this chest are:");
                    for(Item item : chest.getItems()){
                        if(player.addItem(item))
                            output.println(String.format("\t%s", item));
                    }

                    chest.setCollected(true);
                }

            } else {
                execute((Openable) chest);
            }
        }

        @Override
        public void execute(Door door) {
            execute((Openable) door);
        }

        @Override
        public void execute(Seller seller) {
            output.println("You are in front of a seller!");
        }

        @Override
        public void execute(Wall wall) {
            output.println("You are in front of an empty wall!");
        }

        private void execute(Openable openable) {
            if(openable.isUnlocked()) {

                if(openable.isOpen())
                    output.println(String.format("The %s is open!", openable));
                else
                    output.println(String.format("The %s is not open!", openable));

            } else {
                output.println(String.format("The %s is locked, you need a %s to unlock it!", openable, openable.getKey()));
            }
        }
    }
}
