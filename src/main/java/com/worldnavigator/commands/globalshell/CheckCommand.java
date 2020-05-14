package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.*;

public class CheckCommand implements Command {

    @Override
    public void execute(String... args) {

        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        RoomSide side = maze.getRoom(player.getRoom()).getSide(player.getDirection());

        if(side instanceof Openable) {

            Openable openable = (Openable) side;

            if(!openable.isUnlocked()) {
                System.out.printf("%s is locked, %s is needed to unlock!", openable, openable.getKey());

            } else if(!openable.isOpen()) {
                System.out.printf("%s is not open!", openable);
            }
        }
    }

    @Override
    public String toString() {
        return "check";
    }
}
