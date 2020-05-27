package com.worldnavigator.commands.global;

import com.worldnavigator.commands.*;
import com.worldnavigator.commands.trade.TradeShell;
import com.worldnavigator.maze.Player;

import java.util.HashMap;

public final class GlobalShell extends Shell {

    public GlobalShell(Player player, Input input, Output output) {
        super(player, input, output, "", new HashMap<>());

        addCommand("trade", new TradeShell(player, input, output));
        addCommand("rotate", new RotateCommand(player, output));
        addCommand("status", new StatusCommand(player, output));
        addCommand("move", new MoveCommand(player, output));
        addCommand("look", new LookCommand(player, output));
        addCommand("check", new CheckCommand(player, output));
        addCommand("open", new OpenCommand(player, output));
        addCommand("use", new UseCommand(player, output));
        addCommand("switch-lights", new SwitchLightsCommand(player, output));
        addCommand("reload", new ReloadCommand());
    }

    @Override
    public void execute(String... args) {
        output.println("Welcome to World Navigator!");
        output.println("To see the available commands");
        output.println("and how to use them type \"?list\"");
        output.println("");

        super.execute(args);

        output.println("");
        output.println("Good bye!");
        output.println("Hope you enjoyed the game!");
    }

    @Override
    public String usage() {
        return "global";
    }

    @Override
    public String description() {
        return "Top level shell for controlling the game.";
    }
}
