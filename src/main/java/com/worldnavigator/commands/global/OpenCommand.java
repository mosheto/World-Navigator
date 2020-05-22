package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.*;

public class OpenCommand implements Command {

    private final Output output;

    public OpenCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Player player = GameState.getState().getPlayer();

        RoomSide side = GameState.getState()
                .getMaze()
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        if(side instanceof Openable) {

            Openable openable = (Openable) side;

            if(openable.isUnlocked()) {

                if(openable.isOpen()) {
                    output.println(String.format("The %s is already open!", openable));
                } else {
                    openable.open();
                    output.println(String.format("The %s is now open!", openable));
                }

            } else {
                output.println(String.format("The %s is locked, %s is needed to unlock\n", openable, openable.getKey()));
            }

        } else {
            output.println("This is not something you can open!");
        }
    }

    @Override
    public String toString() {
        return "open";
    }
}
