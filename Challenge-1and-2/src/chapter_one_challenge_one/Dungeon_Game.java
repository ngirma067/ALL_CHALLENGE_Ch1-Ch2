/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_one_challenge_one;

import java.util.Random;
import java.util.Scanner;

public class Dungeon_Game {
    public static void main(String[] args) {

        int health = 100;
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to the Dungeon! ===");
        System.out.println("Starting Health: " + health);
        System.out.println("You must clear 5 rooms.");
        System.out.println();

        for (int room = 1; room <= 5; room++) {
            System.out.println("--- Room " + room + " ---");

            if (health <= 0) {
                System.out.println("Your health reached zero! You were defeated in room " + (room-1) + ".");
                break;
            }

            System.out.println("Current Health: " + health);
            System.out.print("Press 'enter' to enter the room: ");
            scanner.nextLine(); // Wait for user to press enter


            int event = rand.nextInt(3) + 1;

            switch (event) {
                case 1: // Trap
                    health -= 20;
                    System.out.println("A trap sprung! You lost 20 health.");
                    System.out.println("Current Health: " + health);
                    break;

                case 2: // Health potion
                    int oldHealth = health;
                    health += 15;
                    if (health > 100) {
                        health = 100; // Health cannot exceed 100
                        System.out.println("You found a healing potion! Health restored to 100.");
                    } else {
                        System.out.println("You found a healing potion! Gained 15 health.");
                    }
                    System.out.println("Current Health: " + health);
                    break;

                case 3: // Monster
                    System.out.println("A monster appears! Guess a number (1-5) to defeat it.");
                    int monsterNumber = rand.nextInt(5) + 1;
                    int guess;
                    int attempts = 0;


                    do {
                        System.out.print("Enter your guess (1-5): ");

                        // Validate integer input
                        while (!scanner.hasNextInt()) {
                            System.out.println("Please enter a valid number!");
                            scanner.next(); // Clear invalid input
                            System.out.print("Enter your guess (1-5): ");
                        }

                        guess = scanner.nextInt();
                        scanner.nextLine(); // Clear newline character
                        attempts++;

                        if (guess < 1 || guess > 5) {
                            System.out.println("Number must be between 1 and 5!");
                        } else if (guess != monsterNumber) {
                            System.out.println("Wrong! Try again.");
                        }
                    } while (guess != monsterNumber);

                    System.out.println("You defeated the monster! It took " + attempts + " attempts.");
                    break;
            }

            System.out.println(); // Empty line for spacing

            if (health <= 0) {
                System.out.println("Your health reached zero! Game over.");
                break;
            }
        }


        System.out.println("======================");
        if (health > 0) {
            System.out.println("Congratulations! You cleared the dungeon!");
            System.out.println(" Final Health: " + health);

            if (health >= 80) {
                System.out.println("Excellent performance!");
            } else if (health >= 50) {
                System.out.println("Good job!");
            } else {
                System.out.println("You barely made it!");
            }
        } else {
            System.out.println("Game Over! You were defeated in the dungeon.");
            System.out.println("Try again!");
        }

        scanner.close();
    }
}

