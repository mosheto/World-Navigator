package com.worldnavigator.commands.trade;

import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.maze.Player;
import com.worldnavigator.maze.room.Seller;


public final class ListCommand implements Command {

    private final Player player;
    private final Output output;

    public ListCommand(Player player, Output output) {
        this.player = player;
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Seller seller = (Seller) player
                .current()
                .getSide(player.getDirection());

        output.println("Seller's list:");
        seller.getPrices().forEach((key, val) -> output.println(String.format("%s: %d", key, val)));
    }

    @Override
    public String name() {
        return "list";
    }

    @Override
    public String description() {
        return "Lists the items that are available to sell or buy";
    }
}
