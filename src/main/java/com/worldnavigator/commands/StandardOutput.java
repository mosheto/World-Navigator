package com.worldnavigator.commands;

public final class StandardOutput implements Output {

    @Override
    public void print(String str) {
        System.out.print(str);
    }

    @Override
    public void println(String str) {
        System.out.println(str);
    }
}
