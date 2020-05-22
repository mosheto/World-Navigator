package com.worldnavigator.commands;


public interface Output {

    void print(String str);

    default void print(Object obj) {
        print(String.valueOf(obj));
    }

    void println(String str);

    default void println(Object obj) {
        println(String.valueOf(obj));
    }
}
