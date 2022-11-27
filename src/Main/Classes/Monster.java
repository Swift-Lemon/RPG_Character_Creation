package Main.Classes;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Monster extends Character {

    private enum MonsterType {
        HERON ("Heron", 10, 8, 8, 15,
                new ImageIcon(MonsterType.class.getResource("/Main/images/heron.png") ) ),
        FOX ("Fox", 8, 5, 10, 8,
                new ImageIcon(MonsterType.class.getResource("/Main/images/fox.png") ) ),
        TURTLE ("Snapping Turtle", 15, 15, 5, 5,
                new ImageIcon(MonsterType.class.getResource("/Main/images/turtle.png") ) );

        private String name;
        private int hitPoints;
        private int defense;
        private int agility;
        private int baseAttack;
        private ImageIcon image;

        MonsterType(String name, int hitPoints, int defense, int agility, int baseAttack, ImageIcon image) {
            this.name = name;
            this.hitPoints = hitPoints;
            this.defense = defense;
            this.agility = agility;
            this.baseAttack = baseAttack;
            this.image = image;
        }

        private static Random rand = new Random();
        private static ArrayList<MonsterType> OPTIONS = new ArrayList<>(Arrays.asList(HERON, FOX, TURTLE));

        public static MonsterType randomMonster() {
            return OPTIONS.get(rand.nextInt(OPTIONS.size()));
        }
    }

    private MonsterType type;

    public Monster() {
        this.type = MonsterType.randomMonster();
        //it's possible below will need to be this.type.name
        //use the parent class methods to avoid duplicate code
        setName(type.name);
        setCharacterImage(type.image);
        setHitPoints(type.hitPoints);
        setDefense(type.defense);
        setAgility(type.agility);
        setBaseAttack(type.baseAttack);
    }

    @Override
    public String toString() {
        return "Monster: " + this.getName() + "\n-----" + super.toString();}
}
