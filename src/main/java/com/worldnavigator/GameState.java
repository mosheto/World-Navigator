package com.worldnavigator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.worldnavigator.components.Maze;
import com.worldnavigator.components.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GameState {

    private static final GameState state = new GameState();
    private GameState(){}

    private Maze maze;
    private Player player;

    private Path path;

    public void load(Path path) throws IOException {
        this.path = path;

        ObjectMapper mapper = new ObjectMapper();

        maze = mapper.readValue(
                Files.newBufferedReader(path.resolve("maze.json")),
                Maze.class
        );

        player = mapper.readValue(
                Files.newBufferedReader(path.resolve("player.json")),
                Player.class
        );
    }

    public void reload() throws IOException {
        load(path);
    }

    public Maze getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public static GameState getState() {
        return state;
    }
}
