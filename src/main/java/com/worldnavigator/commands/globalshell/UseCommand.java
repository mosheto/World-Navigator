package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.*;
import com.worldnavigator.components.items.Flashlight;
import com.worldnavigator.components.items.Item;
import com.worldnavigator.components.items.Key;

import java.util.HashMap;
import java.util.Map;

public class UseCommand implements Command {

    Map<String, Command> actions;

    public UseCommand() {
        actions = new HashMap<>();

        actions.put("flashlight", args -> {

            Map<String, Item> items = GameState.getState().getPlayer().getItems();

            if(items.containsKey("flashlight")) {
                Flashlight fl = (Flashlight) items.get("flashlight");

                if (fl.isOn())
                    fl.turnOff();
                else
                    fl.turnOn();
            } else {
                System.out.println("You don't have a flashlight to use!");
            }
        });

        actions.put("key", args -> {
            Maze maze = GameState.getState().getMaze();
            Player player = GameState.getState().getPlayer();

            Map<String, Item> items = player.getItems();

            if(items.containsKey(args[0])) {
                Key key = (Key) items.get(args[0]);

                RoomSide side = maze.getRoom(player.getRoom()).getSide(player.getDirection());
                if(side instanceof Openable) {

                    Openable openable = (Openable) side;
                    openable.unlock(key);

                    if(openable.isUnlocked()) {
                        System.out.println("");
                    }

                } else {
                    System.out.printf("you can't use %s to open %s\n", key, side);
                }
            } else {
                System.out.printf("You don't have a %s\n", args[0]);
            }
        });
    }

    @Override
    public void execute(String... args) {
        if(args.length < 1) {
            System.out.println("Invalid argument to the use command!");
            System.out.println("Argument is <item>");
            return;
        }

        String item = String.join(" ", args);
        String type = args[args.length - 1];

        actions.get(type).execute(item);
    }

    @Override
    public String toString() {
        return "use <item>";
    }
}
