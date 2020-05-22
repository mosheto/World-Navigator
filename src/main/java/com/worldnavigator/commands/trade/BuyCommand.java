package com.worldnavigator.commands.trade;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.Seller;
import com.worldnavigator.components.items.Item;
import com.worldnavigator.components.items.ItemFactory;
import com.worldnavigator.components.items.NoSuchItemException;

public class BuyCommand implements Command {

    private final Output output;

    public BuyCommand(Output output) {
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

        if(seller.getPrices().containsKey(item)) {

            int price = seller.getItemPrice(item);

            if(player.getItems().containsKey(item)) {
                output.println("You already have this item!");

            } else if(player.getGold() >= price) {
                addItemToPlayer(item, player);
                player.setGold(player.getGold() - price);

            } else {
                output.println(String.format("You don't have enough gold to buy the %s!", item));
            }

        } else {
            output.println("The seller doesn't have this item!");
            output.println("Try \"list\" command to see whats available.");
        }
    }

    private void addItemToPlayer(String name, Player player) {
        try {
            Item item = ItemFactory.getFactory().item(name);
            player.addItem(item);

        } catch (NoSuchItemException e) {
            output.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "buy <item>";
    }
}