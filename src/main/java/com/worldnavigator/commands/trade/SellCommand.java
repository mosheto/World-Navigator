package com.worldnavigator.commands.trade;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Seller;

public class SellCommand implements Command {

    private final Output output;

    public SellCommand(Output output) {
        this.output = output;
    }

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Seller seller = (Seller) maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        String item = String.join(" ", args);

        if(player.getItems().containsKey(item)) {

            if(seller.getPrices().containsKey(item)) {

                player.setGold(player.getGold() + seller.getItemPrice(item));
                player.getItems().remove(item);

            } else {
                output.println(String.format("The seller doesn't have a %s on it's prices list.", item));
            }

        } else {
            output.println("You don't have this item.");
        }
    }

    @Override
    public String toString() {
        return "sell <item>";
    }
}
