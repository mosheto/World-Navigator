package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Direction;
import com.worldnavigator.components.Player;

public class RotateCommand implements Command {

    private final Output output;

    public RotateCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String ...args) {
        if(!validate(args)) {
            output.println("Invalid argument to the rotate command!");
            output.println("Arguments are <left> or <right>");
            return;
        }

        String argument = args[0];
        Player player = GameState.getState().getPlayer();

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
    public String toString() {
        return "rotate <left|right>";
    }
}
