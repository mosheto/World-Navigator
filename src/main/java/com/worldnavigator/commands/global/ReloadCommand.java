package com.worldnavigator.commands.global;

import com.worldnavigator.GameState;
import com.worldnavigator.commands.Command;

import java.io.IOException;

public class ReloadCommand implements Command {

    @Override
    public void execute(String... args) {
        try {
            GameState.getState().reload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "reload";
    }
}
