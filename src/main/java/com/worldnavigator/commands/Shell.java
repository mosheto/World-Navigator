package com.worldnavigator.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This class acts as a shell like bash shell
 * it has a prompt and can accept commands and execute them
 */
public class Shell implements Command {

    private final String PROMPT_SUFFIX = "> ";

    private String prompt;

    private BufferedReader reader;
    private Map<String, Command> commands;

    public Shell() {
        this("");
    }

    public Shell(String prompt) {
        this.prompt = prompt;
        this.commands = new HashMap<>();
        this.reader = new BufferedReader(new InputStreamReader(System.in));

        addCommand("help", new Help());
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

        while(true) {

            try {
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

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This is the main processing of the command
     * entered by the user
     */
    private void execute(String command, String args) {

        if(commands.containsKey(command)) {
            commands.get(command).execute(args.split("\\s+"));
        } else {
            System.out.println("Invalid command!");
            System.out.println("Type \"help\" to see the list of commands");
        }
    }

    /**
     * @returns a tuple of two elements
     * the first is the command name
     * and the second is the arguments
     * @throws IOException
     */
    private String[] next() throws IOException {
        System.out.print(prompt + PROMPT_SUFFIX);
        String line = reader.readLine().trim().toLowerCase();

        String[] splits = line.split("\\s+", 2);

        if(splits.length == 1)
            return new String[] { splits[0], "" };

        return splits;
    }

    private class Help implements Command {

        @Override
        public void execute(String... args) {

            // Get help for a specific command
            if(args.length == 1) {
                if(commands.containsKey(args[0])) {
                    System.out.println(commands.get(args[0]));
                    return;

                } else if(args[0].length() > 1) {
                    System.out.println("There is no command with that name!");
                    return;

                }
            }

            System.out.println("Available commands are:");
            for(Command command : commands.values())
                System.out.println(command);
        }

        @Override
        public String toString() {
            return "help <command>";
        }
    }
}
