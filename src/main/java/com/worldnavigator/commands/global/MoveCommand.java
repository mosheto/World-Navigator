package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.*;

public class MoveCommand implements Command {

    private final Output output;

    public MoveCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        if(!validate(args)) {
            output.println("Invalid argument to the move command!");
            output.println("Arguments are <forward> or <backward>");
            return;
        }

        Maze maze = GameState.getState().getMaze();

        Player player = GameState.getState().getPlayer();
        Room room = maze.getRoom(player.getRoom());

        Direction direction = player.getDirection();

        if(args[0].equals("backward"))
            direction = Direction.getReverseDirection(player.getDirection());

        RoomSide side = room.getSide(direction);

        if(side instanceof Door) {
            Door door = (Door) side;

            if(!door.isUnlocked()) {
                output.println(String.format("Door is locked, %s is needed to unlock!", door.getKey()));

            }else if(!door.isOpen()) {
                output.println("Door is not open!");

            } else if(door.getNextRoom() >= 0) {
                player.setRoom(door.getNextRoom());

            } else {
                output.println("Congratulations you won!");
                output.println("you have reached the end of the maze!");
            }

        } else {
            output.println("You can't move there is no door!");
        }
    }

    private boolean validate(String... args) {
        return args.length == 1
                && args[0].equals("forward")
                || args[0].equals("backward");
    }

    @Override
    public String toString() {
        return "move <forward|backward>";
    }
}
