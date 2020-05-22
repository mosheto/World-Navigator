package com.worldnavigator.commands.global;

import com.worldnavigator.commands.Shell;
import com.worldnavigator.commands.StandardInput;
import com.worldnavigator.commands.StandardOutput;
import com.worldnavigator.commands.trade.TradeShell;

import java.util.HashMap;

public final class GlobalShell extends Shell {

    public GlobalShell() {
        super(
                new StandardInput(),
                new StandardOutput(),
                "",
                new HashMap<>()
        );

        addCommand("trade", new TradeShell(input, output));

        addCommand("rotate", new RotateCommand(output));
        addCommand("status", new StatusCommand(output));
        addCommand("move", new MoveCommand(output));
        addCommand("look", new LookCommand(output));
        addCommand("check", new CheckCommand(output));
        addCommand("open", new OpenCommand(output));
        addCommand("use", new UseCommand(output));
        addCommand("switch-lights", new SwitchLightsCommand(output));
        addCommand("reload", new ReloadCommand());
    }


    @Override
    public void execute(String... args) {
        output.println("Welcome to World Navigator!");
        output.println("To see the available commands");
        output.println("and how to use them type \"help\"");
        output.println("");

        super.execute(args);

        output.println("");
        output.println("Good bye!");
        output.println("Hope you enjoyed the game!");
    }
}
