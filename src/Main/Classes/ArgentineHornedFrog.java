package Main.Classes;

import javax.swing.*;
import java.util.Random;

public class ArgentineHornedFrog extends Player{

    private ImageIcon image = new ImageIcon(this.getClass().getResource("/Main/images/HornedFrog.png"));

    public ArgentineHornedFrog() {
        setCharacterImage(image);
        setClassDescription("The Argentine Horned Frog has a mean look in its eye, and packs a punch.");
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
        return "Player: " + getName() + "\n-----" +
                "\nClass: Argentine Horned Frog" + super.toString();
    }
}
