package com.worldnavigator.commands.tradeshell;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Shell;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.RoomSide;
import com.worldnavigator.components.Seller;

public class TradeShell extends Shell {

    public TradeShell() {
        super("trade");
        addCommand("buy", new BuyCommand());
        addCommand("sell", new SellCommand());
        addCommand("list", new ListCommand());
    }

    @Override
    public void execute(String... args) {

        Maze maze = GameState.getState().getMaze();
        Player player = GameState.getState().getPlayer();

        RoomSide side = maze
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        if(side instanceof Seller) {
            super.execute(args);
        } else {
            System.out.println("You must be facing a seller to enter trade mode.");
        }
    }

    @Override
    public String toString() {
        return "trade";
    }
}
