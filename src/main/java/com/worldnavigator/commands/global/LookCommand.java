package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Room;
import com.worldnavigator.components.RoomSide;
import com.worldnavigator.components.items.Flashlight;
import com.worldnavigator.components.items.Item;

import java.util.Map;

public class LookCommand implements Command {

    private final Output output;

    public LookCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Room room = maze.getRoom(player.getRoom());
        RoomSide side = room.getSide(player.getDirection());

        Map<String, Item> items = player.getItems();

        if(room.isLit()
                || (items.containsKey("flashlight")
                && ((Flashlight) items.get("flashlight")).isOn())
        ) {
            output.println(side);
        } else {
            output.println("Dark");
        }
    }

    @Override
    public String toString() {
        return "look";
    }
}
