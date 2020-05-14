package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.*;

public class MoveCommand implements Command {

    @Override
    public void execute(String... args) {
        if(!validate(args)) {
            System.out.println("Invalid argument to the move command!");
            System.out.println("Arguments are <forward> or <backward>");
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
                System.out.printf("Door is locked, %s is needed to unlock!\n", door.getKey());

            }else if(!door.isOpen()) {
                System.out.println("Door is not open!");

            } else if(door.getNextRoom() >= 0) {
                player.setRoom(door.getNextRoom());

            } else {
                System.out.println("Congrats you won!");
                System.out.println("you have reached the end of the maze!");
            }

        } else {
            System.out.println("You can't move there is no door!");
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
