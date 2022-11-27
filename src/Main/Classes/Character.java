package Main.Classes;

import javax.swing.*;

abstract public class Character {
    private String name;
    private ImageIcon image;
    private int hitPoints;
    private int defense;
    private int agility;
    private int baseAttack;

    //no constructor needed
    //Character will store all the following variables, but their values are determined by subclasses/ player input

    public String getName() {
        return name;
    }

    public void setName(String name) {this.name = name;}

    public ImageIcon getCharacterImage() {return this.image;}

    public void setCharacterImage(ImageIcon image) {this.image = image;}

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    //Method for printing info shared by all characters
    public String toString() {
        return String.format("\nHP: %d\tDefense: %d\tAgility: %d\tBase Attack: %d",
                this.hitPoints, this.defense, this.agility, this.baseAttack);
    }
}
