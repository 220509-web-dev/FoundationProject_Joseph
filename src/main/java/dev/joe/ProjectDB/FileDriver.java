package dev.joe.ProjectDB;

import dev.joe.models.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileDriver {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Welcome to our app!");
        Scanner consoleReader = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Please choose from the following options: ");
            System.out.println("1) Register \n2) Login \n3) Exit");
            System.out.println("> ");

            String userSelection = consoleReader.nextLine();
            switch (userSelection) {

                case "1":
                    System.out.println("Please provide us with some basic information:");
                    System.out.print("Firstname: ");
                    String firstname = consoleReader.nextLine();
                    System.out.print("Lastname: ");
                    String lastname = consoleReader.nextLine();
                    System.out.print("Username: ");
                    String username = consoleReader.nextLine();
                    System.out.print("Password: ");
                    String password = consoleReader.nextLine();

                    User newUser = new User(firstname, lastname, username, password);
                    System.out.printf("You provided the following: %s \n", newUser);

                    try(FileWriter writer = new FileWriter("resources/users.csv", true)) {
                        writer.write(firstname + ',' + lastname + ',' + username + ',' + password + '\n');
                        System.out.println("Successfully persisted data to file.");
                    } catch (IOException e) {
                        System.err.println("Could not get access to file.");
                        System.out.println("Data not persisted to file.");
                    } catch (Exception e) {
                        System.out.println("Some unexpected exception occurred.");
                    }
                    break;

                case "2":
                    System.out.println("You selected Login.");
                    break;

                case "3":
                    System.out.println("Exiting application...");
                    running = false;
                    break;

                default:
                    System.err.println("Invalid entry.");
                    Thread.sleep(500);
                    System.out.println("Please try again.");

            }
        }
    }
}
