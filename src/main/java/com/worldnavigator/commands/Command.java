package com.worldnavigator.commands;

@FunctionalInterface
public interface Command {

    void execute(String ...args);
}
