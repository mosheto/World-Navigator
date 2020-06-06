package com.worldnavigator.commands.trade;

import com.worldnavigator.commands.Input;
import com.worldnavigator.commands.Output;
import com.worldnavigator.commands.Shell;
import com.worldnavigator.maze.Player;
import com.worldnavigator.maze.room.RoomSide;
import com.worldnavigator.maze.room.Seller;


public final class TradeShell extends Shell {

    private final Player player;

    public TradeShell(Player player, Input input, Output output) {
        super(input, output, "trade");

        this.player = player;

        addCommands(
            new BuyCommand(player, output),
            new SellCommand(player, output),
            new ListCommand(player, output)
        );
    }

    @Override
    public void execute(String... args) {

        RoomSide side = player
                .current()
                .getSide(player.getDirection());

        if(side instanceof Seller) {
            super.execute(args);
        } else {
            output.println("You must be facing a seller to enter trade mode.");
        }
    }

    @Override
    public String name() {
        return "trade";
    }

    @Override
    public String description() {
        return "Interact with the seller";
    }
}
