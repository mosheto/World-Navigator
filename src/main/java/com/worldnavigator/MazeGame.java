package com.worldnavigator;

import com.worldnavigator.commands.StandardInput;
import com.worldnavigator.commands.StandardOutput;
import com.worldnavigator.commands.global.GlobalShell;
import com.worldnavigator.maze.Maze;

import java.io.IOException;
import java.nio.file.Paths;

public class MazeGame {

    public void start(String path) {

        try {

            GameLoader.getLoader().load(Paths.get(path));

            new GlobalShell(
                    GameLoader.getLoader().getMaze().player(),
                    new StandardInput(),
                    new StandardOutput()
            ).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
