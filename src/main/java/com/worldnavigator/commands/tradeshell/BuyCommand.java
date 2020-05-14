package com.worldnavigator.commands.tradeshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Seller;

public class BuyCommand implements Command {

    @Override
    public void execute(String... args) {
        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        Seller seller = (Seller) maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        String item = String.join(" ", args);

        if(seller.getItems().containsKey(item)) {

            int price = seller.getItemPrice(item);

            if(player.getItems().containsKey(item)) {
                System.out.println("You already have this item.");

            } else if(player.getGold() >= price) {
                player.getItems().put(item, seller.getItem(item));
                player.setGold(player.getGold() - price);

            } else {
                System.out.printf("You don't have enough gold to buy the %s.\n", item);
            }

        } else {
            System.out.println("The seller doesn't have this item.");
            System.out.println("Try \"list\" command to see whats available.");
        }
    }

    @Override
    public String toString() {
        return "buy <item>";
    }
}