package com.worldnavigator.commands.globalshell;

import com.worldnavigator.commands.Shell;
import com.worldnavigator.commands.tradeshell.TradeShell;

public class GlobalShell extends Shell {

    public GlobalShell() {
        this.addCommand("rotate", new RotateCommand());
        this.addCommand("status", new StatusCommand());
        this.addCommand("move", new MoveCommand());
        this.addCommand("look", new LookCommand());
//        this.addCommand("check", new CheckCommand());
        this.addCommand("open", new OpenCommand());
        this.addCommand("trade", new TradeShell());
//        this.addCommand("use", new UseCommand());
        this.addCommand("switch-lights", new SwitchLightsCommand());
        this.addCommand("reload", new ReloadCommand());
    }


    @Override
    public void execute(String... args) {
        System.out.println("Welcome to World Navigator!");
        System.out.println("To see the available commands");
        System.out.println("and how to use them type \"help\"");
        System.out.println();

        super.execute(args);

        System.out.println();
        System.out.println("Good bye!");
        System.out.println("Hope you enjoyed the game!");
    }
}
