package Main.Classes;

import javax.swing.*;

public class Weapon {

    //similar to monsters, weapon type will be handled with an enum to avoid unneccessary subclasses
    public enum WeaponType {
        DAGGER ("Dagger", "A balanced light weapon, but perhaps still too heavy for a frog.",5.0, 5.0,
                new ImageIcon(WeaponType.class.getResource("/Main/images/dagger.png") ) ),
        CLUB ("Club", "A stick with a round head you found on the forest floor.",8.0, 10.0,
                new ImageIcon(WeaponType.class.getResource("/Main/images/club.png") ) ),
        DISCUS ("Mushroom Discus", "You tear the cap off a mushroom and use it as a ranged weapon.",2.0, 1.0,
                new ImageIcon(WeaponType.class.getResource("/Main/images/mushroom.png") ) );

        private String weaponName;
        private String weaponDescription;
        private double damage;
        private double weight;
        private ImageIcon image;

        WeaponType(String weaponName, String weaponDescription, double damage, double weight, ImageIcon image) {
            this.weaponName = weaponName;
            this.weaponDescription = weaponDescription;
            this.damage = damage;
            this.weight = weight;
            this.image = image;
        }
    }

    private String name;
    private String description;
    private double weight;
    private double attackModifier;
    private ImageIcon image;

    public Weapon (WeaponType wt) {
        this.name = wt.weaponName;
        this.description = wt.weaponDescription;
        this.weight = wt.weight;
        this.attackModifier = wt.damage;
        this.image = wt.image;
    }

    public double getAttackModifier() {return this.attackModifier;}
    public double getWeight() {return this.weight;}

    public String getWeaponDescription() {return this.description;}

    public ImageIcon getWeaponImage() {return this.image;}

    public String toString() {
        return String.format("\nWeapon: %s\nWeight: %.1f\tAttack Mod: %.1f",
                this.name, this.weight, this.attackModifier);
    }
}
