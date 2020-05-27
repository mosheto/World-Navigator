package com.worldnavigator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldnavigator.maze.Maze;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameLoader {

    private static final GameLoader loader = new GameLoader();
    private GameLoader(){}

    private Path path;

    private Maze maze;

    public void load(Path path) throws IOException {
        this.path = path;

        ObjectMapper mapper = new ObjectMapper();

        maze = mapper.readValue(
                Files.newBufferedReader(path.resolve("maze.json")),
                Maze.class
        );
    }

    public void reload() throws IOException {
        load(path);
    }

    public Maze getMaze() {
        return maze;
    }

    public static GameLoader getLoader() {
        return loader;
    }
}
