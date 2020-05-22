package com.worldnavigator.components.items;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Output;
import com.worldnavigator.components.Openable;
import com.worldnavigator.components.Player;
import com.worldnavigator.components.RoomSide;

public class UseVisitor implements ItemVisitor{

    private final Output output;

    public UseVisitor(Output output) {
        this.output = output;
    }

    @Override
    public void execute(Key key) {
        Player player = GameState.getState().getPlayer();

        RoomSide side = GameState
                .getState()
                .getMaze()
                .getRoom(player.getRoom())
                .getSide(player.getDirection());

        if(side instanceof Openable) {

            Openable openable = (Openable) side;

            if(openable.isUnlocked()) {
                if(openable.lock(key)) {
                    output.println(String.format("The %s is locked now", openable));
                } else {
                    output.println(String.format("The key you are holding is not for this %s", openable));
                }

            } else {
                if(openable.unlock(key)) {
                    output.println(String.format("The %s is unlocked now!", openable));
                } else {
                    output.println(String.format("The key you are holding is not for this %s", openable));
                }
            }

        } else {
            output.println("This is not something you can open!");
        }
    }

    @Override
    public void execute(Flashlight flashlight) {
        flashlight.setOn(!flashlight.isOn());
    }
}
