/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labweek8_kenanakyurek;

/**
 *
 * @author akyur
 */
public class Warrior extends GameCharacter implements Attacker {

    private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public int takeDamage(int damage) {

        if (damage <= 0 || !isAlive()) {
            return 0;
        }

        int reducedDamage = damage - armor / 2;

        if (reducedDamage < 1) {
            reducedDamage = 1;
        }

        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {

        if (!isAlive()) {
            System.out.println(getName() + " cannot attack.");
            return 0;
        }

        if (target == null || !target.isAlive()) {
            System.out.println("Target cannot be attacked.");
            return 0;
        }

        int damage = calculatePower() / 4;

        return target.takeDamage(damage);
    }

    @Override
    public String getCharacterInfo() {

        return "Warrior - Name: " + getName()
                + ", Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", Armor: " + armor
                + ", Power: " + calculatePower();
    }
}
