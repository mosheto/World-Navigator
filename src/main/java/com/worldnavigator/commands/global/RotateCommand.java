package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.Direction;
import com.worldnavigator.maze.Player;

public class RotateCommand implements Command {

    private final Player player;
    private final Output output;

    public RotateCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String ...args) {
        if(!validate(args)) {
            output.println("Invalid argument to the rotate command!");
            output.println("Argument is either <left> or <right>");
            return;
        }

        String argument = args[0];
        if(argument.equalsIgnoreCase("left")) {

            Direction direction = Direction.getLeftDirection(player.getDirection());
            player.setDirection(direction);

        } else if(argument.equalsIgnoreCase("right")) {
            Direction direction = Direction.getRightDirection(player.getDirection());
            player.setDirection(direction);
        }
    }

    private boolean validate(String... args) {
        return args.length == 1
                && args[0].equals("left")
                || args[0].equals("right");
    }

    @Override
    public String usage() {
        return "rotate <left|right>";
    }

    @Override
    public String description() {
        return "Rotate the player to the left or right";
    }
}
