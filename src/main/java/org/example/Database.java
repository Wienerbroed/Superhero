package org.example;

import java.util.ArrayList;

public class Database {
    //Arraylist to populate with heroes
    private final ArrayList<Hero> heroList;

    //Constructor
    public Database(){
        this.heroList = new ArrayList<>();
    }

    //List of Heroes to add to test program
    public void populateDatabase(){
        Hero superman = new Hero("Superman", "Clark Kent", "Lasereyes, Superstrenght, Bulletproof",
                1925, 2000, false);
        Hero spiderMan = new Hero("Spider-Man", "Peter Parker", "Superstrengt, webshooting, felxibility",
                1950, 200, true);

        heroList.add(superman);
        heroList.add(spiderMan);
    }

    //Print function for program
    public void printDatabase(){
        for(Hero hero: heroList){
            System.out.println(hero);
        }
    }

    //Function to add a hero to heroList
    public void addHero(Hero hero){
        heroList.add(hero);
    }

    // Search function for program
    public Hero searchHero(String name) {
        String searchword = name.toLowerCase();
        for (Hero hero : heroList) {
            if (hero.getHeroName().toLowerCase().equals(searchword)) {
                return hero;
            }
        }
        return null;
    }

    //Edit function for hero
    public void editHero(Hero hero){
        String searchword = hero.heroName.toLowerCase();
        for(Hero hero2: heroList){
            if (hero2.heroName.toLowerCase().equals(searchword)){
                hero2.setHeroName(hero.getHeroName());
                hero2.setSecretIdentity(hero.getSecretIdentity());
                hero2.setSuperpower(hero.getSuperpower());
                hero2.setYearOfCreation(hero.getYearOfCreation());
                hero2.setPowerLvl(hero.getPowerLvl());
                hero2.setHuman(hero.isHuman);
            }
        }
    }

    //Function to Remove hero
    // Function to remove hero
    public void removeHero(Hero hero) {
        heroList.remove(hero);
    }
}
