package com.robowalker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot current = null;
        while (true) {
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("> Enter the command: ");
            String command = inputScanner.nextLine(); // "i 10"
            String[] commands = command.split(" "); // ["i", "10"]
            switch (commands[0].toUpperCase()) {
                case "I":
//                    New Robot(15)
                    current = new Robot(Integer.parseInt(commands[1]));
                    break;
                case "U":
                    current.changePenStatus("up");
                    break;

                case "D":
                    current.changePenStatus("down");
                    break;

                case "M":
                    if (current != null) {
                        current.move(Integer.parseInt(commands[1]));
                    } else {
                        System.out.println("Init before moving");
                    }
                    break;

                case "L":
                    current.rotate("left");
                    break;

                case "R":
                    current.rotate("right");
                    break;

                case "C":
                    System.out.println(current.printCoordinates());
                    break;

                case "P":
                    current.printMatrix();
                    break;

                case "Q":
                    System.out.println("Program Terminated");
                    System.exit(0);
            }
        }
    }
}
