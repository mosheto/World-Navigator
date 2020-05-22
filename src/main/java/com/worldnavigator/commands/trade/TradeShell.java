package com.worldnavigator.commands.trade;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Input;
import com.worldnavigator.commands.Output;
import com.worldnavigator.commands.Shell;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.RoomSide;
import com.worldnavigator.components.Seller;

import java.util.HashMap;

public final class TradeShell extends Shell {

    public TradeShell(Input input, Output output) {
        super(
                input,
                output,
                "trade",
                new HashMap<>()
        );

        addCommand("buy", new BuyCommand(output));
        addCommand("sell", new SellCommand(output));
        addCommand("list", new ListCommand(output));
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
            output.println("You must be facing a seller to enter trade mode.");
        }
    }

    @Override
    public String toString() {
        return "trade";
    }
}
