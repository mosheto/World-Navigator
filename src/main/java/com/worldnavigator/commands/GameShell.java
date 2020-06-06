package com.worldnavigator.commands;

import com.worldnavigator.GameLoader;
import com.worldnavigator.commands.global.GlobalShell;
import com.worldnavigator.maze.Maze;
import com.worldnavigator.maze.Player;

import java.io.IOException;

public class GameShell extends Shell {

    private Player player;

    public GameShell(Input input, Output output) {
        super(input, output, "menu");

        addCommands(
                new Start(),
                new Continue()
        );
    }


    @Override
    public void execute(String... args) {

        output.println("Welcome to World Navigator!");
        output.println("To list the available commands and see how to use them");
        output.println("Type \"list-commands\" or \"help <command-name>\"");
        output.println("");

        super.execute(args);
    }

    @Override
    public String name() {
        return "game";
    }

    @Override
    public String description() {
        return "Controls the game like starting a new game or continue the current game.";
    }

    private class Start implements Command {

        @Override
        public void execute(String... args) {

            try {

                Maze maze = GameLoader.getLoader().load();
                player = maze.player();

                new GlobalShell(
                        player,
                        input,
                        output
                ).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String name() {
            return "start";
        }

        @Override
        public String description() {
            return "Start a new game.";
        }
    }

    private class Continue implements Command {

        @Override
        public void execute(String... args) {

            if(player == null || player.isDone()) {
                output.println("There is no game to continue!");

            } else {

                new GlobalShell(
                        player,
                        input,
                        output
                ).execute();
            }
        }

        @Override
        public String name() {
            return "continue";
        }

        @Override
        public String description() {
            return "Continues the current game if the player started one";
        }
    }
}
