package org.example;

import java.util.Scanner;

public class UI {
    // Instantiating Database
    Database db = new Database();

    public void welcome() {
        // Option choice value
        int optionChoice;

        // Scanner for input
        Scanner sc = new Scanner(System.in);

        // Program start
        System.out.println("Welcome to Heromanager");

        db.populateDatabase();

        while (true) {
            // Menu choices
            System.out.println("\n1. See Herolist \n2. Add Hero \n3. Search for Hero \n4. Exit program");

            optionChoice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (optionChoice) {
                case 1:
                    db.printDatabase();
                    break;
                case 2:
                    System.out.println("Enter Hero Name: ");
                    String heroName = sc.nextLine();
                    System.out.println("Enter Hero Secret Identity: ");
                    String secretIdentity = sc.nextLine();
                    System.out.println("Enter Hero Superpower: ");
                    String superpower = sc.nextLine();
                    System.out.println("Enter Hero Creation year: ");
                    int creationYear = sc.nextInt();
                    System.out.println("Enter Hero Powerlevel: ");
                    int powerlevel = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    System.out.println("Is the Hero a Human? yes(Ja) / no(Nej): ");
                    String isHumanInput = sc.nextLine();
                    boolean isHuman = isHumanInput.equalsIgnoreCase("yes") || isHumanInput.equalsIgnoreCase("y")
                            || isHumanInput.equalsIgnoreCase("ja") || isHumanInput.equalsIgnoreCase("j");

                    db.addHero(new Hero(heroName, secretIdentity, superpower, creationYear, powerlevel, isHuman));
                    break;
                case 3:
                    System.out.println("Enter hero name to search:");
                    String searchName = sc.nextLine();
                    Hero foundHero = db.searchHero(searchName);
                    if (foundHero != null) {
                        System.out.println("Hero found: " + foundHero);
                        System.out.println("1. Edit Hero");
                        System.out.println("2. Remove Hero");
                        System.out.println("3. Return to Main Menu");
                        int subChoice = sc.nextInt();
                        sc.nextLine();
                        switch (subChoice) {
                            case 1:
                                System.out.println("Enter new Name for Hero (leave blank to keep current): ");
                                String newName = sc.nextLine();
                                if (!newName.isEmpty()) {
                                    foundHero.setHeroName(newName);
                                }

                                System.out.println("Enter new Secret Identity for Hero (leave blank to keep current): ");
                                String newIdentity = sc.nextLine();
                                if (!newIdentity.isEmpty()) {
                                    foundHero.setSecretIdentity(newIdentity);
                                }

                                System.out.println("Enter new Superpowers for Hero (leave blank to keep current): ");
                                String newSuperpower = sc.nextLine();
                                if (!newSuperpower.isEmpty()) {
                                    foundHero.setSuperpower(newSuperpower);
                                }

                                System.out.println("Enter new Year of Creation for Hero (leave blank to keep current): ");
                                String newYearOfCreationStr = sc.nextLine();
                                if (!newYearOfCreationStr.isEmpty()) {
                                    int newYearOfCreation = Integer.parseInt(newYearOfCreationStr);
                                    foundHero.setYearOfCreation(newYearOfCreation);
                                }

                                System.out.println("Enter new Powerlevel for Hero (leave blank to keep current): ");
                                String newPowerLvlStr = sc.nextLine();
                                if (!newPowerLvlStr.isEmpty()) {
                                    int newPowerLvl = Integer.parseInt(newPowerLvlStr);
                                    foundHero.setPowerLvl(newPowerLvl);
                                }

                                System.out.println("Is your Hero still a Human (yes/no): ");
                                String newIsHumanStr = sc.nextLine();
                                if (!newIsHumanStr.isEmpty()) {
                                    boolean newIsHuman = newIsHumanStr.equalsIgnoreCase("yes") ||
                                            newIsHumanStr.equalsIgnoreCase("y") || newIsHumanStr.equalsIgnoreCase("ja")
                                            || newIsHumanStr.equalsIgnoreCase("j");
                                    foundHero.setHuman(newIsHuman);
                                }

                                db.editHero(foundHero);
                                break;
                            case 2:
                                db.removeHero(foundHero);
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid option");
                        }
                    } else {
                        System.out.println("Hero not found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
