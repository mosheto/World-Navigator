package com.worldnavigator.components;

public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public static Direction getRightDirection(Direction direction) {
        switch(direction) {
            case NORTH:
                return EAST;
            case EAST:
                return SOUTH;
            case SOUTH:
                return WEST;
            case WEST:
                return NORTH;
            default:
                return null;
        }
    }

    public static Direction getLeftDirection(Direction direction) {
        switch(direction) {
            case NORTH:
                return WEST;
            case WEST:
                return SOUTH;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            default:
                return null;
        }
    }

    public static Direction getReverseDirection(Direction direction) {
        switch(direction) {
            case NORTH:
                return SOUTH;
            case SOUTH:
                return NORTH;
            case WEST:
                return EAST;
            case EAST:
                return WEST;
            default:
                return null;
        }
    }
}
