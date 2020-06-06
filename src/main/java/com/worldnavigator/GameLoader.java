package com.worldnavigator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldnavigator.maze.Maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameLoader {

    private static final GameLoader loader = new GameLoader();
    private GameLoader(){}

    private Path path;

    public void setPath(Path path) {
        this.path = path;
    }

    public Maze load() throws IOException {

        try(BufferedReader reader = Files.newBufferedReader(path)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(reader, Maze.class);
        }
    }

    public static GameLoader getLoader() {
        return loader;
    }
}
