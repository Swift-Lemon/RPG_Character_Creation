package Main.Classes;

public abstract class Player extends Character {

    private Weapon weapon;
    private String classDescription;

    //abstract method needed here so that you can call it as player using polymorphism
    public abstract void rerollStats();

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setClassDescription(String description) {this.classDescription = description;}
    public String getClassDescription() {return this.classDescription;}

    //toString method:
    @Override
    public String toString() {
        return super.toString() + weapon.toString();
    }
}
