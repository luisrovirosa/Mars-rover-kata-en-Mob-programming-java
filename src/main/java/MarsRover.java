import java.util.Arrays;
import java.util.List;

public class MarsRover {
    public static final int LEFT_ROTATION = -1;
    public static final int RIGHT_ROTATION = +1;
    private final Position position = new Position();
    private final List<Character> rotations = Arrays.asList('N', 'E', 'S', 'W');

    public MarsRover() {
        position.setOrientation('N');
        position.setPositionX(0);
        position.setPositionY(0);
    }

    public String execute(String commands) {
        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            if (command == 'M') {
                moveForward();
            }
            if ('R' == command) {
                rotateRight();
            }

            if ('L' == command) {
                rotateLeft();
            }
        }


        return position.getPositionX() + ":" + position.getPositionY() + ":" + position.getOrientation();
    }

    private void moveForward() {
        switch (position.getOrientation()) {
            case 'N':
                position.setPositionY((position.getPositionY() + 1 + 10) % 10);
                break;
            case 'S':
                position.setPositionY((position.getPositionY() - 1 + 10) % 10);
                break;
            case 'E':
                position.setPositionX((position.getPositionX() + 1 + 10) % 10);
                break;
            case 'W':
                position.setPositionX((position.getPositionX() - 1 + 10) % 10);
                break;
        }
    }

    private void rotateLeft() {
        position.setOrientation(rotate(LEFT_ROTATION));
    }

    private void rotateRight() {
        position.setOrientation(rotate(RIGHT_ROTATION));
    }

    private Character rotate(int direction) {
        return rotations.get((rotations.indexOf(position.getOrientation()) + direction + 4) % 4);
    }

}
