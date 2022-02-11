# Kata Mars Rover
## Context
We were on a mob remote session on with [Software Crafters meetup](https://www.meetup.com/es-ES/Software-Craftsmanship-Murcia) on November 30th of 2020.

We test-drive and change driver every 5 minutes.

The day after I wanted to keep coding the kata and I finished with a solution that tries to provide a good Object oriented code.

## Requirements
[Requirements](https://katalyst.codurance.com/mars-rover)

## Solution
### Classes explanation
 - [MarsRover](src/main/java/mars/MarsRover.java) that define initial MarsMap, the accepted input and process the commands. 
 - [MarsMap](src/main/java/mars/MarsMap.java) that handles the size of the world and the obstacles.
 - [MarsCommand](src/main/java/mars/command/MarsCommand.java) that defines the format of accepted commands on the system: [MoveForward](src/main/java/mars/command/move/MoveForward.java), [RotateLeft](src/main/java/mars/command/rotation/RotateLeft.java) and [RotateRight](src/main/java/mars/command/rotation/RotateRight.java).
 - [Orientation](src/main/java/mars/orientation/Orientation.java) to define the expected behaviour for a specific robot facing direction. There are 4 main orientations: [North](src/main/java/mars/orientation/North.java), [East](src/main/java/mars/orientation/East.java), [South](src/main/java/mars/orientation/South.java) and [West](src/main/java/mars/orientation/West.java).
 - [RoverSituation](src/main/java/mars/RoverSituation.java): handles the [Position](src/main/java/mars/Position.java) and the [Orientation](src/main/java/mars/orientation/Orientation.java) and calculate a new situation using the rotation and move commands. 

### Applied patterns
 - [Command](https://sourcemaking.com/design_patterns/command): allowing adding other commands easily. Just creating a class and adding the input related with the command.
 - [State](https://sourcemaking.com/design_patterns/state): encapsulating the different orientation states and the expected behaviour.

## Author
Luis Rovirosa [@luisrovirosa](https://www.twitter.com/luisrovirosa)

[Others During the Mob](https://github.com/luisrovirosa/Mars-rover-kata-en-Mob-programming-java/graphs/contributors) 