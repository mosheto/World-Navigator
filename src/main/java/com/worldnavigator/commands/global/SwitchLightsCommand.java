package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Room;

public class SwitchLightsCommand implements Command {

    private final Output output;

    public SwitchLightsCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Room room = maze.getRoom(player.getRoom());

        if(room.hasLights()) {
            room.switchLights();

        } else {
            output.println("The room doesn't have lights!");
            output.println("You should use a flashlight to see.");
        }
    }

    @Override
    public String toString() {
        return "switch-lights";
    }
}
