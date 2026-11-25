/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labweek8_kenanakyurek;

/**
 *
 * @author akyur
 */
public class Mage extends GameCharacter implements Attacker, Supporter {

    private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
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

        if (mana < 20) {
            System.out.println("Not enough mana.");
            return 0;
        }

        int power = calculatePower();

        mana -= 20;

        return target.takeDamage(power / 3);
    }

    @Override
    public int heal(GameCharacter target) {

        if (!isAlive()) {
            System.out.println(getName() + " cannot heal.");
            return 0;
        }

        if (target == null || !target.isAlive()) {
            return 0;
        }

        if (mana < 15) {
            System.out.println("Not enough mana.");
            return 0;
        }

        mana -= 15;

        return target.restoreHealth(getLevel() * 2);
    }

    @Override
    public String getCharacterInfo() {

        return "Mage - Name: " + getName()
                + ", Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", Mana: " + mana
                + ", Power: " + calculatePower();
    }
}
