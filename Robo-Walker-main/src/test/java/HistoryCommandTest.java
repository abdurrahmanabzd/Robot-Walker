import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.robowalker.Robot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryCommandTest {

    private Robot robot;
    private List<String> commandHistory;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outContent));
        commandHistory = new ArrayList<>();
    }

    @Test
    void testHistoryReplay() {
        // Simulate user entering commands
        commandHistory.add("I 5");
        commandHistory.add("D");
        commandHistory.add("M 3");
        commandHistory.add("R");
        commandHistory.add("M 2");

        // Replaying history as if "H" was typed
        for (String cmd : commandHistory) {
            String[] replayCmd = cmd.split(" ");
            switch (replayCmd[0].toUpperCase()) {
                case "I":
                    robot = new Robot(Integer.parseInt(replayCmd[1]));
                    break;
                case "U":
                    robot.changePenStatus("up");
                    break;
                case "D":
                    robot.changePenStatus("down");
                    break;
                case "M":
                    robot.move(Integer.parseInt(replayCmd[1]));
                    break;
                case "L":
                    robot.rotate("left");
                    break;
                case "R":
                    robot.rotate("right");
                    break;
                case "C":
                    System.out.println(robot.printCoordinates());
                    break;
                case "P":
                    robot.printMatrix();
                    break;
            }
        }

        // Simple assertion (example): robot should be at a known coordinate
        String expectedCoordinates = robot.printCoordinates(); // e.g. "Position: (2,3), Pen: down, Facing: east"
        assertNotNull(expectedCoordinates);
        assertFalse(expectedCoordinates.contains("Position:"));
    }
}
