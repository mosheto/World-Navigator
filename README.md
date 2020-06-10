# World Navigator

## Packaging and running 

To get an executable jar file

```
$ maven package
```

After that you can run the game using

Giving that the `maze.json` is in the same directory as the jar file.
```
$ java -jar world-navigator-0.0.1-jar-with-dependencies.jar maze.json
```

## Game Controls

The `maze-filename` argument is a file that describes 
the maze and the initial state of the player.

The file should be in `json` format.

if you want to build your own maze go to [Maze Specification](#maze-specification). 

Atfer stating the game you be in the menu where you can start the game or exit the game.

```
Welcome to World Navigator!
To list the available commands and see how to use them
Type "list-commands" or "help <command-name>"

menu> list-commands
Available commands are:
exit
help <command-name>
list-commands
start
menu> 

```

After starting the game you can control the player to navigate the maze.

```
menu> start
> list-commands
Available commands are:
exit
help <command-name>
list-commands
rotate <left|right>
move <forward|backward>
trade
use <item>
switch-lights
check
look
open
status
> 
```

## Maze Specification

The maze file is a `json` file and here is the specification to write your own maze.

### Maze object
First the top level object will hold the properties for the maze.

```
{
  "time": 3600, // Time in minutes, if the player exceeds it they lose.
  "rooms": [ Room ], // Array of rooms that will be in the maze.

  
  "gold": 550, // Initial amount of gold the player will have in the start.
  "location": 0, // The room number of the starting room of the maze.

  "direction": "NORTH" // The direction the player will face in the start.
                       // The value is one of "NORTH", "EAST", "SOUTH" or "WEST"
}
```

### Room object

```
{
  "sides" : { // defines what the four walls of the room will be.
    "NORTH" : { RoomSide },
    "EAST" : { RoomSide },
    "SOUTH" : { RoomSide },
    "WEST" : { RoomSide }
  },
  "lit" : true, // If the room is lit or not.
  "hasLights": true // If the room has lights.
                    // if this is false so does the lit property.
}
```

### RoomSide object

There are for types of a wall

#### Empty wall

```json
{
  "@type": "wall"
}
```

#### Door

```
{
  "@type": "door",
  "key": null, // This is null if the door can't be locked or unlocked 
               // or a description of the key in the format of "color key"
               // where color is replaced with the color of the key.

  "nextRoom": -1, // room number that the door opens to, 
                  // could by -1 to indicate the end of the maze.

  "open": false, // If the door is open or not.
  "unlocked": true // If the door is locked or not, if the door doesn't have a key defined
                   // this must be true.
}
```

#### Seller

```
{
  "@type": "seller",
  "prices": { // prices list.
    "flashlight": 20, // The description of the item and it's price.
    "blue key": 120,
    "brown key": 200
  }
}
```

#### Mirror and Painting

```
{
  "@type" : "painting", // or "mirror" to define a mirror.
  "item": "brown key"    // The hidden item, if there is no item hidden this proprty can be
                                                negelected.
}
```

### Items

Items are defined by a string representing the item description.

There are two items in the game.

#### Flashlight

It's description is `flashlight`.

#### Key

It's description is `color key` where color is the key color.
 