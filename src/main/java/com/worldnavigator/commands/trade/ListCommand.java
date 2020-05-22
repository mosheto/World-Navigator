package com.worldnavigator.commands.trade;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Seller;

import java.util.Map;


public class ListCommand implements Command {

    private final Output output;

    public ListCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Seller seller = (Seller) maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        for (Map.Entry<String, Integer> item : seller.getPrices().entrySet()) {
            output.println(String.format("%s: %d", item.getKey(), item.getValue()));
        }
    }

    @Override
    public String toString() {
        return "list";
    }
}
