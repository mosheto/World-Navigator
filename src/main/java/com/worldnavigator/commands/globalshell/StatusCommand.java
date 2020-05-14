package com.worldnavigator.commands.globalshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.items.Item;
import com.worldnavigator.components.Player;

public class StatusCommand implements Command {

    @Override
    public void execute(String ...args) {
        Player player = GameState.getState().getPlayer();

        System.out.println("Gold: " + player.getGold());
        System.out.println("Direction: " + player.getDirection());

        System.out.println("Items:");
        for(String item : player.getItems().keySet())
            System.out.println("\t" + item);
    }

    @Override
    public String toString() {
        return "status";
    }
}
