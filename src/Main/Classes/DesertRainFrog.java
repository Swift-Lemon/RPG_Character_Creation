package Main.Classes;

import javax.swing.*;
import java.util.Random;

public class DesertRainFrog extends Player {

    private ImageIcon image = new ImageIcon(this.getClass().getResource("/Main/images/RainFrog.png"));

    public DesertRainFrog() {
        setCharacterImage(image);
        setClassDescription("The Desert Rain Frog is small and soft.");
    }

    private static Random rand = new Random();
    //you can make this a bit more sophisticated and class-specific:
    private static int maxStat = 15;

    @Override
    public void rerollStats() {
        setHitPoints(rand.nextInt(maxStat));
        setDefense(rand.nextInt(maxStat));
        setAgility(rand.nextInt(maxStat));
        setBaseAttack(rand.nextInt(maxStat));
    }

    @Override
    public String toString() {
        return "Player: " + getName() + "\n-----\n" +
                "Class: Desert Rain Frog" + super.toString();
    }

}
