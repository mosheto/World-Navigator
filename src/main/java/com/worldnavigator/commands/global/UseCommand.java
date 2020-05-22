package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.items.*;

import java.util.Map;

public class UseCommand implements Command {

    private final Output output;

    public UseCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        if(args.length < 1) {
            System.out.println("Invalid argument to the use command!");
            System.out.println("Argument is <item>");
            return;
        }

        String item = String.join(" ", args);
        Map<String, Item> items = GameState.getState().getPlayer().getItems();

        if(items.containsKey(item)) {
            items.get(item).accept(new UseVisitor(output));
        } else {
            output.println("You don't have an item with that name!");
        }
    }

    @Override
    public String toString() {
        return "use <item>";
    }
}
