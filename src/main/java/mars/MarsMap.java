package mars;

import mars.command.MarsCommand;

import java.util.List;

public class MarsMap {
    public static final int MARS_SIZE = 10;
    private RoverSituation roverSituation;
    private final List<Position> positionOfObstacles;
    private boolean isThereAnObstacle;

    public MarsMap(RoverSituation roverSituation, List<Position> positionOfObstacles) {
        this.roverSituation = roverSituation;
        this.positionOfObstacles = positionOfObstacles;
    }

    public void execute(MarsCommand command) {
        RoverSituation desiredRoverSituation = command.execute(roverSituation);
        moveRoverTo(situationWithSphericalWorld(desiredRoverSituation));
    }

    private RoverSituation situationWithSphericalWorld(RoverSituation desiredRoverSituation) {
        Position position = positionWithSphericalWorld(desiredRoverSituation.getPosition());
        return desiredRoverSituation.withPosition(position);
    }

    public void moveRoverTo(RoverSituation roverSituation) {
        isThereAnObstacle = isThereAnObstacle(roverSituation);
        if (!isThereAnObstacle){
            this.roverSituation = roverSituation;
        }
    }

    public String getRoverSituation() {
        String representation = roverSituation.toString();
        return isThereAnObstacle ? "O:" + representation : representation;
    }

    private Position positionWithSphericalWorld(Position expectedPosition) {
        return new Position(
                roundWorld(expectedPosition.getPositionX()),
                roundWorld(expectedPosition.getPositionY())
        );
    }

    private int roundWorld(int x) {
        return (x + MARS_SIZE) % MARS_SIZE;
    }

    private boolean isThereAnObstacle(RoverSituation roverSituation) {
        return positionOfObstacles.contains(roverSituation.getPosition());
    }
}
