package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.*;

public class CheckCommand implements Command {

    private final Output output;

    public CheckCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {

        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        RoomSide side = maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        side.accept(new CheckVisitor(output));
    }

    @Override
    public String toString() {
        return "check";
    }
}
