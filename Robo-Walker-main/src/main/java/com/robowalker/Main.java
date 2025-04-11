package com.robowalker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Robot current = null;
        List<String> commandHistory = new ArrayList<>();

        while (true) {
            Scanner inputScanner = new Scanner(System.in);
            System.out.print("> Enter the command: ");
            String command = inputScanner.nextLine().trim();

            // Save to history (excluding H and Q)
            if (!command.equalsIgnoreCase("H") && !command.equalsIgnoreCase("Q")) {
                commandHistory.add(command);
            }

            String[] commands = command.split(" ");

            switch (commands[0].toUpperCase()) {
                case "I":
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

                case "H":
                    System.out.println("Replaying command history...");
                    for (String cmd : commandHistory) {
                        System.out.println("> " + cmd);
                        String[] replayCmd = cmd.split(" ");
                        switch (replayCmd[0].toUpperCase()) {
                            case "I":
                                current = new Robot(Integer.parseInt(replayCmd[1]));
                                break;
                            case "U":
                                current.changePenStatus("up");
                                break;
                            case "D":
                                current.changePenStatus("down");
                                break;
                            case "M":
                                if (current != null) {
                                    current.move(Integer.parseInt(replayCmd[1]));
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
                        }
                    }
                    break;

                case "Q":
                    System.out.println("Program Terminated");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }
    }
}
