package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Room;
import com.worldnavigator.components.RoomSide;
import com.worldnavigator.components.items.Flashlight;
import com.worldnavigator.components.items.Item;

import java.util.Map;

public class LookCommand implements Command {

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Room room = maze.getRoom(player.getRoom());
        RoomSide side = room.getSide(player.getDirection());

        Map<String, Item> items = player.getItems();
        if(room.isLit()
                || items.containsKey("flashlight")
                || ((Flashlight) items.get("flashlight")).isOn()
        ) {
            System.out.println(side);
        } else {
            System.out.println("Dark");
        }
    }

    @Override
    public String toString() {
        return "look";
    }
}
