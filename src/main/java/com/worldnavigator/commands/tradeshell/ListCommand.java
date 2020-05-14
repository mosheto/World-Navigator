package com.worldnavigator.commands.tradeshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Seller;


public class ListCommand implements Command {

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Seller seller = (Seller) maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        seller.getPrices().forEach((key, val) -> {
            System.out.printf("%s: %d\n", key, val);
        });
    }

    @Override
    public String toString() {
        return "list";
    }
}
