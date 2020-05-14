package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.*;

public class OpenCommand implements Command {

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Room room = maze.getRoom(player.getRoom());
        RoomSide side = room.getSide(player.getDirection());

        boolean notOpenable = !(side instanceof Openable);

        if(notOpenable) {
            System.out.println("It's not an openable!");
            return;
        }

        Openable openable = (Openable) side;

        if(!openable.isUnlocked()) {
            System.out.printf("%s is locked, %s is needed to unlock\n", openable, openable.getKey());

        } else if(openable.isOpen()) {
            System.out.printf("%s is already open\n", openable);

        } else {
            openable.open();
            System.out.printf("%s is now open!\n", openable);
        }
    }

    @Override
    public String toString() {
        return "open";
    }
}
