package com.worldnavigator.commands;

public interface Command {

    /**
     *
     * @param args The arguments the command takes
     * @return A String representing what the command did.
     */
    void execute(String ...args);

    /**
     * The format of the usage string is
     * the name of the command then the arguments
     *
     * For example: "move &lt;forward|backward&gt;"
     * @return how to use the command
     */
    String usage();

    /**
     *
     * @return What the command will do if executed
     */
    String description();
}
