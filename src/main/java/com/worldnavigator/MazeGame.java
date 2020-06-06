package com.worldnavigator;

import com.worldnavigator.commands.GameShell;
import com.worldnavigator.commands.StandardInput;
import com.worldnavigator.commands.StandardOutput;

import java.nio.file.Paths;

public class MazeGame {

    public void start(String path) {

        GameLoader
                .getLoader()
                .setPath(Paths.get(path));

        new GameShell(
                new StandardInput(),
                new StandardOutput()
        ).execute();
    }
}
