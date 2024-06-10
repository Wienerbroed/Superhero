package org.example;

public class Hero {

    //Attributes
    String test:
    String heroName;
    String secretIdentity;
    String superpower;
    int yearOfCreation;
    int powerLvl;
    boolean isHuman;

    //Constructor
    public Hero(String heroName, String secretIdentity, String superpower, int yearOfCreation, int powerLvl,
                boolean isHuman) {
        this.heroName = heroName;
        this.secretIdentity = secretIdentity;
        this.superpower = superpower;
        this.yearOfCreation = yearOfCreation;
        this.powerLvl = powerLvl;
        this.isHuman = isHuman;
    }

    //getters
    public String getHeroName() {
        return heroName;
    }

    public String getSecretIdentity() {
        return secretIdentity;
    }

    public String getSuperpower() {
        return superpower;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public int getPowerLvl() {
        return powerLvl;
    }


    //Setters
    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setSecretIdentity(String secretIdentity) {
        this.secretIdentity = secretIdentity;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public void setPowerLvl(int powerLvl) {
        this.powerLvl = powerLvl;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String toString(){
        return (heroName + " " + secretIdentity + " " + superpower + " " + yearOfCreation + " " + powerLvl + " " + isHuman);
    }
}
