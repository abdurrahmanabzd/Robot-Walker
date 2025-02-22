
import com.robowalker.Robot;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RobotTest {
    Robot robot = new Robot(5);

    @org.junit.jupiter.api.Test
    void printCoordinates() {
        assertEquals("Position : 0, 0 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void printCoordinatesAnotherPoint() {
        robot.setCurrentPositionX(1);
        robot.setCurrentPositionY(1);
        assertEquals("Position : 1, 1 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void setValueAtCurrentPosition() {
        robot.setValueAtCurrentPosition();
        assertEquals(1, robot.room[0][0]);
    }

    @org.junit.jupiter.api.Test
    void setValueAtCurrentPositionAtAnotherPoint() {
        robot.setCurrentPositionX(1);
        robot.setCurrentPositionY(1);
        robot.setValueAtCurrentPosition();
        assertEquals(1, robot.room[1][1]);
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenDownToNorth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("down");
        robot.setFaceDirection("north");
        robot.move(3);
        assertEquals("Position : 0, 2 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenDownToEast() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("down");
        robot.setFaceDirection("north");
        robot.rotate("right");
        robot.move(3);
        assertEquals("Position : 2, 0 Pen: down Face: east", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenDownToWest() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("down");
        robot.setFaceDirection("north");
        robot.rotate("right");
        robot.move(3);
        robot.rotate("left");
        robot.move(2);
        robot.rotate("left");
        robot.move(3);
        assertEquals("Position : 0, 2 Pen: down Face: west", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenDownToSouth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("down");
        robot.setFaceDirection("north");
        robot.move(4);
        robot.rotate("right");
        robot.move(2);
        robot.rotate("right");
        robot.move(4);
        assertEquals("Position : 2, 0 Pen: down Face: south", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenUpToNorth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("up");
        robot.setFaceDirection("north");
        robot.move(3);
        assertEquals("Position : 0, 2 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenUpToEast() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("up");
        robot.setFaceDirection("north");
        robot.rotate("right");
        robot.move(3);
        assertEquals("Position : 2, 0 Pen: up Face: east", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenUpToWest() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("up");
        robot.setFaceDirection("north");
        robot.rotate("right");
        robot.move(3);
        robot.rotate("left");
        robot.move(2);
        robot.rotate("left");
        robot.move(3);
        assertEquals("Position : 0, 1 Pen: up Face: west", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveWhenPenUpToSouth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("up");
        robot.setFaceDirection("north");
        robot.move(4);
        robot.rotate("right");
        robot.move(2);
        robot.rotate("right");
        robot.move(4);
        assertEquals("Position : 1, 0 Pen: up Face: south", robot.printCoordinates());
    }
    @org.junit.jupiter.api.Test
    void moveOutOfIndexPenDown() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("down");
        robot.setFaceDirection("north");
        robot.move(20);
        robot.printMatrix();
        assertEquals("Position : 0, 4 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void moveOutOfIndexPenUp() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.changePenStatus("up");
        robot.setFaceDirection("north");
        robot.move(20);
        robot.printMatrix();
        assertEquals("Position : 0, 4 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void changePenDown() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("north");
        robot.changePenStatus("down");
        assertEquals("Position : 0, 0 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void changePenUp() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
//        robot.faceDirection = "north";
        robot.setFaceDirection("north");
        robot.changePenStatus("up");
        assertEquals("Position : 0, 0 Pen: up Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateLeftFromNorth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("north");
        robot.changePenStatus("down");
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: down Face: west", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateLeftFromWest() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("west");
        robot.changePenStatus("down");
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: down Face: south", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateLeftFromSouth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("south");
        robot.changePenStatus("down");
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: down Face: east", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateLeftFromEast() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("east");
        robot.changePenStatus("down");
        robot.rotate("left");
        assertEquals("Position : 0, 0 Pen: down Face: north", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateRightFromNorth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("north");
        robot.changePenStatus("down");
        robot.rotate("right");
        assertEquals("Position : 0, 0 Pen: down Face: east", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateRightFromEast() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("east");
        robot.changePenStatus("down");
        robot.rotate("right");
        assertEquals("Position : 0, 0 Pen: down Face: south", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateRightFromSouth() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("south");
        robot.changePenStatus("down");
        robot.rotate("right");
        assertEquals("Position : 0, 0 Pen: down Face: west", robot.printCoordinates());
    }

    @org.junit.jupiter.api.Test
    void rotateRightFromWest() {
        robot.setCurrentPositionX(0);
        robot.setCurrentPositionY(0);
        robot.setFaceDirection("west");
        robot.changePenStatus("down");
        robot.rotate("right");
        assertEquals("Position : 0, 0 Pen: down Face: north", robot.printCoordinates());
    }
}
