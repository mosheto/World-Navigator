package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.room.Openable;
import com.worldnavigator.maze.Player;
import com.worldnavigator.maze.room.RoomSide;
import com.worldnavigator.maze.items.*;

import java.util.Map;

public class UseCommand implements Command {

    private final Player player;
    private final Output output;

    public UseCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        if(args.length < 1) {
            output.println("Invalid argument to the use command!");
            output.println("Argument is <item>");
            return;
        }

        String item = String.join(" ", args);
        Map<String, Item> items = player.getItems();

        if(items.containsKey(item)) {
            items.get(item).accept(new UseVisitor(player, output));
        } else {
            output.println("You don't have an item with that name!");
        }
    }

    @Override
    public String name() {
        return "use";
    }

    @Override
    public String args() {
        return "<item>";
    }

    @Override
    public String description() {
        return "Uses the item, for example using a flashlight would it turn on or off.";
    }

    private static class UseVisitor implements ItemVisitor {

        private final Player player;
        private final Output output;

        public UseVisitor(Player player, Output output) {
            this.player = player;
            this.output = output;
        }

        @Override
        public void execute(Key key) {

            RoomSide side = player
                    .current()
                    .getSide(player.getDirection());

            if(side instanceof Openable) {

                Openable openable = (Openable) side;

                if(openable.isUnlocked()) {

                    if(openable.lock(key)) {
                        output.println(String.format("The %s is now locked!", openable));
                    } else {
                        output.println(String.format("The key can't be used on this %s!", openable));
                    }

                } else {

                    if(openable.unlock(key)) {
                        output.println(String.format("The %s is now unlocked!", openable));
                    } else {
                        output.println(String.format("The key can't be used on this %s!", openable));
                    }
                }

            } else {
                output.println("This is not something you can open!");
            }
        }

        @Override
        public void execute(Flashlight flashlight) {
            flashlight.setOn(!flashlight.isOn());
        }
    }
}
