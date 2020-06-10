package com.worldnavigator.commands.global;

import com.worldnavigator.commands.*;
import com.worldnavigator.commands.trade.TradeShell;
import com.worldnavigator.maze.Player;

import java.util.LinkedHashMap;

public final class GlobalShell extends Shell {

    private Player player;

    public GlobalShell(Player player, Input input, Output output) {
        super(input, output, "", new LinkedHashMap<>());

        this.player = player;

        addCommands(
            new TradeShell(player, input, output),
            new RotateCommand(player, output),
            new StatusCommand(player, output),
            new MoveCommand(player, output),
            new LookCommand(player, output),
            new CheckCommand(player, output),
            new OpenCommand(player, output),
            new UseCommand(player, output),
            new SwitchLightsCommand(player, output)
        );
    }

    @Override
    public void execute(String... args) {

        super.execute(args);

        if(player.isDone()) {
            output.println("Congratulations you won!");
            output.println("You have successfully got out of the maze!");
        }
    }

    @Override
    public boolean done() {
        return super.done() || player.isDone();
    }

    @Override
    public String name() {
        return "global";
    }

    @Override
    public String description() {
        return "Top level shell for controlling the game.";
    }
}
