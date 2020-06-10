package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.Player;

public final class StatusCommand implements Command {

    private final Player player;
    private final Output output;

    public StatusCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        output.println("Gold: " + player.getGold());
        output.println("Direction: " + player.getDirection());

        if(player.getItems().size() == 0) {
            output.println("You have no items!");
        } else {
            output.println("Items:");
            for(String item : player.getItems().keySet())
                output.println(String.format("\t%s", item));
        }
    }

    @Override
    public String name() {
        return "status";
    }

    @Override
    public String description() {
        return "gives which direction the player is " +
                "facing and the amount of gold and items that he has";
    }
}
