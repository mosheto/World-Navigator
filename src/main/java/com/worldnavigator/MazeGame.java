package com.worldnavigator;

import com.worldnavigator.commands.global.GlobalShell;

import java.io.IOException;
import java.nio.file.Paths;

public class MazeGame {

    public void start(String path) {

        try {
            GameState.getState().load(Paths.get(path));
            new GlobalShell().execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
