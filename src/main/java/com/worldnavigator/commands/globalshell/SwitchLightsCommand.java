package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Room;

public class SwitchLightsCommand implements Command {

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Room room = maze.getRoom(player.getRoom());

        if(room.hasLights()) {
            room.switchLights();

        } else {
            System.out.println("The room doesn't have lights.");
            System.out.println("You should use a flashlight to see.");
        }
    }

    @Override
    public String toString() {
        return "switch-lights";
    }
}
