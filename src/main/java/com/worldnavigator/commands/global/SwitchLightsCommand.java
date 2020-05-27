package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.Maze;
import com.worldnavigator.maze.Player;
import com.worldnavigator.maze.room.Room;

public class SwitchLightsCommand implements Command {

    private final Player player;

    private final Output output;

    public SwitchLightsCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Room room = player.current();

        if(room.hasLights()) {
            room.switchLights();

        } else {
            output.println("The room doesn't have lights!");
            output.println("You should use a flashlight to see.");
        }
    }

    @Override
    public String usage() {
        return "switch-lights";
    }

    @Override
    public String description() {
        return "Will turn the room lights on or off if the room have lights";
    }
}
