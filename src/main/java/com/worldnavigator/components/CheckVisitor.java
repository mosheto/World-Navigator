package com.worldnavigator.components;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.items.Item;

public class CheckVisitor implements RoomSideVisitor {

    private final Output output;

    public CheckVisitor(Output output) {
        this.output = output;
    }

    @Override
    public void execute(Mirror mirror) {
        execute((Stash) mirror);
    }

    @Override
    public void execute(Painting painting) {
        execute((Stash) painting);
    }

    @Override
    public void execute(Chest chest) {

        if(chest.isOpen() && !chest.isCollected()) {
            output.println(String.format("You got %d gold from this chest!", chest.getGold()));

            Player player = GameState.getState().getPlayer();
            player.setGold(player.getGold() + chest.getGold());
        }

        execute((Openable) chest);
    }

    @Override
    public void execute(Door door) {
        execute((Openable) door);
    }

    @Override
    public void execute(Seller seller) {
        output.println("You are in front of a seller!");
    }

    @Override
    public void execute(Wall wall) {
        output.println("You are in front of an empty wall!");
    }

    //TODO: Add items that you don't have.
    private void execute(Stash stash) {

        if(stash.isCollected()) {
            output.println("The stash is already collected!");
        } else {

            output.println("The items you acquired from this stash are:");

            Player player = GameState.getState().getPlayer();
            for(Item item : stash.collect()){
                if(player.addItem(item))
                    output.println(String.format("\t%s", item));
            }
        }
    }

    private void execute(Openable openable) {
        if(openable.isUnlocked()) {

            if(openable instanceof Stash)
                execute((Stash) openable);
            else {

                if(openable.isOpen())
                    output.println(String.format("The %s is open!", openable));
                else
                    output.println(String.format("The %s is not open!", openable));
            }

        } else {
            output.println(String.format("The %s is locked , %s is needed to unlock!", openable, openable.getKey()));
        }
    }
}
