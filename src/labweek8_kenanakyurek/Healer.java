/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labweek8_kenanakyurek;

/**
 *
 * @author akyur
 */
public class Healer extends GameCharacter implements Supporter {

    private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return healAmount;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
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

        return target.restoreHealth(
                healAmount + getLevel()
        );
    }

    @Override
    public String getCharacterInfo() {

        return "Healer - Name: " + getName()
                + ", Level: " + getLevel()
                + ", Health: " + getHealth() + "/" + getMaxHealth()
                + ", Heal Amount: " + healAmount
                + ", Power: " + calculatePower();
    }
}
