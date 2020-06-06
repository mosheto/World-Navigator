package com.worldnavigator.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInput implements Input {

    private final BufferedReader reader;

    public StandardInput() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String read() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
