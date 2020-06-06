package com.worldnavigator.maze.items;

public class ItemFactory {

    private static final ItemFactory factory = new ItemFactory();
    private ItemFactory(){}

    public Item valueOf(String s) throws NoSuchItemException {
        s = s.trim().toLowerCase();

        if(s.equals("flashlight")) {
            return new Flashlight();

        } else if(s.endsWith(" key")) {
            return new Key(s.split("\\s+")[0]);
        }

        throw new NoSuchItemException("There are no items with such description!");
    }

    public static ItemFactory getFactory() {
        return factory;
    }
}
