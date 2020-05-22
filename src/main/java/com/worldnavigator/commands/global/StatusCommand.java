package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Player;

public class StatusCommand implements Command {

    private final Output output;

    public StatusCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String ...args) {
        Player player = GameState.getState().getPlayer();

        output.println("Gold: " + player.getGold());
        output.println("Direction: " + player.getDirection());

        output.println("Items:");
        for(String item : player.getItems().keySet())
            output.println(String.format("\t%s", item));
    }

    @Override
    public String toString() {
        return "status";
    }
}
