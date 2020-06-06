# Effective Java

## 
# Clean Code

# Design Patterns

## Composite Pattern

Defining the commands hierarchy where a simple command is a leaf
and the shell is a composite.

Each shell has a list of commands that are related to the giving shell
and a shell can have another shell in the list of it's commands.

![Composite](./Composite.png)

## Iterator Pattern

Defining the relation between the maze and the player.

That is the player is an iterator of the maze.

By making the player an iterator you can have more than player
for the same maze and the you don't have to give 
the maze instance with the player instance. 

![Iterator](./Iterator.png)

## Visitor Pattern

This pattern is used in the `check`, `look` and `use` commands as these
commands deals with each type differently.

![RoomSideVisitor](./RoomSideVisitor.png)

and visitor for the items

![ItemVisitor](./ItemVisitor.png)

## Abstract Factory Pattern

This pattern is used in `ItemFactory` class.

The class is implemented using a factory method `valueOf`
which takes a `String` that represents the item description following
the item description format described in its `toString()` method 
and returns the matching `Item` object.

And the class is a Singleton as one factory is needed.

![AbstractFactory](./AbstractFactory.png)

## Singleton Pattern

This pattern is used in the `ItemFactory` and the `GameLoader`

as we need one object from these classes and global access to them.


# SOLID Principles