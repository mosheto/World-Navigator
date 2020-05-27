package com.worldnavigator.commands.global;

import com.worldnavigator.GameLoader;
import com.worldnavigator.commands.Command;

import java.io.IOException;

public class ReloadCommand implements Command {

    @Override
    public void execute(String... args) {
        try {
            GameLoader.getLoader().reload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String usage() {
        return "reload";
    }

    @Override
    public String description() {
        return "Reloads the game to it's initial state";
    }
}
