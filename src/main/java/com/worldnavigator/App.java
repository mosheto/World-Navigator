package com.worldnavigator;

public class App {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: ./wn maze-filename");
            return;
        }

        new MazeGame().start(args[0]);
    }
}
