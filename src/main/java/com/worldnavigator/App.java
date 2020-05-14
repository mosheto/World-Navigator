package com.worldnavigator;

public class App {

    public static void main(String[] args) {
        if(args.length != 1) {
            System.err.println("Usage: wn map-path");
            return;
        }

        new MazeGame().start(args[0]);
    }
}
