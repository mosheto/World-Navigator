package com.worldnavigator.commands;

import com.worldnavigator.maze.Player;

import java.util.Map;

/**
 * This class acts as a shell like bash shell
 * it has a prompt and can accept commands and execute them
 */
public abstract class Shell implements Command {

    private final String prompt;
    private final String PROMPT_SUFFIX = "> ";

    protected final Input input;
    protected final Output output;

    private final Player player;
    private final Map<String, Command> commands;

    public Shell(Player player, Input input, Output output, String prompt, Map<String, Command> commands) {
        this.input = input;
        this.output = output;
        this.prompt = prompt;
        this.commands = commands;
        this.player = player;

        addCommand("?help", new Help());
        addCommand("?list", new List());
    }

    public void addCommand(String name, Command command) {
        this.commands.put(name.trim().toLowerCase(), command);
    }

    /**
     * This is the shell's main loop
     * here it will get the command from the user
     * and determine which command to execute
     *
     * @param args
     */
    @Override
    public void execute(String... args) {

        while(!player.isDone()) {
            output.print(prompt + PROMPT_SUFFIX);
            String[] splits = next();

            String command = splits[0];
            String arguments = splits[1];

            if(command.equals("")) {
                continue;
            } if(command.equals("exit")) {
                break;
            } else {
                execute(command, arguments);
            }
        }

        if(player.isDone()) {
            output.println("Congratulations you won!");
            output.println("You have successfully got out of the maze!");
        }
    }

    /**
     * This is the main processing of the command
     * entered by the user
     */
    private void execute(String command, String args) {

        if(commands.containsKey(command)) {

            if(args.isEmpty())
                commands.get(command).execute();
            else
                commands.get(command).execute(args.split("\\s+"));

        } else {
            output.println("Invalid command!");
            output.println("Type \"help\" to see the list of commands.");
        }
    }

    /**
     * @returns a tuple of two elements
     * the first is the command name
     * and the second is the arguments
     */
    private String[] next() {
        String[] splits = input.read()
                .trim()
                .toLowerCase()
                .split("\\s+", 2);

        if(splits.length == 1)
            return new String[] { splits[0], "" };

        return splits;
    }

    private class Help implements Command {

        @Override
        public void execute(String... args) {

            if(args.length == 1) {

                String commandName = args[0];
                if(commands.containsKey(commandName)) {
                    Command command = commands.get(commandName);

                    output.println("Usage: " + command.usage());
                    output.println(command.description());

                } else {
                    output.println("There is no command with that name!");
                }
            } else {
                output.println("Missing required argument <command-name>");
            }
        }

        @Override
        public String usage() {
            return "?help <command-name>";
        }

        @Override
        public String description() {
            return "Give a help message for the given command";
        }
    }

    private class List implements Command {
        @Override
        public void execute(String... args) {
            output.println("Available commands are:");
            for(Command command : commands.values())
                output.println(command.usage());
        }

        @Override
        public String usage() {
            return "?list";
        }

        @Override
        public String description() {
            return "List all commands that can be called";
        }
    }
}
