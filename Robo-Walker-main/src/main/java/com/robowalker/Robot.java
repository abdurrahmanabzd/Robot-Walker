package com.robowalker;

public class Robot {
    public int[][] room;
    public int currentPositionX;
    public int currentPositionY;
    public int size;
    public String faceDirection;
    public String pen;

    public Robot(int size) {
        this.room = new int[size][size];
        this.size = size;
        this.currentPositionX = 0;
        this.currentPositionY = 0;
        this.faceDirection = "north";
        this.pen = "up";
    }

    public void setCurrentPositionY(int currentPositionY) {
        if (currentPositionY < this.size && currentPositionY >= 0) {
            this.currentPositionY = currentPositionY;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void setFaceDirection(String faceDirection) {
        this.faceDirection = faceDirection;
    }

    public void setCurrentPositionX(int currentPositionX) {
        if (currentPositionX < this.size && currentPositionX >= 0) {
            this.currentPositionX = currentPositionX;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void setValueAtCurrentPosition() {
        this.room[this.currentPositionX][this.currentPositionY] = 1;
    }

    public void move(int steps) {
        try {
            if (this.pen == "down") {
                if (this.room[this.currentPositionX][this.currentPositionY] == 0) {
                    this.setValueAtCurrentPosition();
                    steps = steps - 1;                    // to avoid double counting
//                  steps = steps;
                }
                for (int i = 0; i < steps; i = i + 1) {
                    switch (this.faceDirection) {
                        case "north":
                            this.setCurrentPositionY(this.currentPositionY + 1);
                            this.setValueAtCurrentPosition();
                            break;
                        case "south":
                            this.setCurrentPositionY(this.currentPositionY - 1);
                            this.setValueAtCurrentPosition();
                            break;
                        case "east":
                            this.setCurrentPositionX(this.currentPositionX + 1);
                            this.setValueAtCurrentPosition();
                            break;

                        case "west":
                            this.setCurrentPositionX(this.currentPositionX - 1);
                            this.setValueAtCurrentPosition();
                            break;
                    }
                }
            } else if (this.pen == "up") {
                if (this.room[this.currentPositionX][this.currentPositionY] == 0) {
                    steps = steps - 1;                    // to avoid double counting
//                  steps = steps;
                }
                for (int i = 0; i < steps; i = i + 1) {
                    switch (this.faceDirection) {
                        case "north":
                            this.setCurrentPositionY(this.currentPositionY + 1);
                            break;
                        case "south":
                            this.setCurrentPositionY(this.currentPositionY - 1);
                            break;
                        case "east":
                            this.setCurrentPositionX(this.currentPositionX + 1);
                            break;
                        case "west":
                            this.setCurrentPositionX(this.currentPositionX - 1);
                            break;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException err) {
            System.out.println("moved to edge of room could not go to the size specified due to size constraint");
        }
    }

    public void changePenStatus(String status) {
        this.pen = status;
    }

    public String printCoordinates() {
        return "Position : " + this.currentPositionX + ", " + this.currentPositionY + " Pen: " + this.pen.toLowerCase()
                + " Face: " + this.faceDirection.toLowerCase();
    }

    public void printMatrix() {
        int[][] rotatedArray = new int[this.size][this.size];
        for (int i = 0; i < this.size; i = i + 1) {
            for (int j = 0; j < this.size; j = j + 1) {
                rotatedArray[i][j] = this.room[j][this.size - i - 1];
            }
        }
        for (int i = 0; i < size; i = i + 1) {
            for (int j = 0; j < size; j = j + 1) {
                if (rotatedArray[i][j] > 0) {
                    System.out.print(" * ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public void rotate(String direction) {
        if (direction == "left") {
            switch (this.faceDirection) {
                case "north":
                    this.faceDirection = "west";
                    break;
                case "south":
                    this.faceDirection = "east";
                    break;
                case "east":
                    this.faceDirection = "north";
                    break;
                case "west":
                    this.faceDirection = "south";
                    break;
            }
        } else {
            switch (this.faceDirection) {
                case "north":
                    this.faceDirection = "east";
                    break;
                case "south":
                    this.faceDirection = "west";
                    break;
                case "east":
                    this.faceDirection = "south";
                    break;
                case "west":
                    this.faceDirection = "north";
                    break;
            }
        }
    }
}
