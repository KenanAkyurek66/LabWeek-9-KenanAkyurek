/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labweek8_kenanakyurek;

/**
 *
 * @author akyur
 */
import java.util.ArrayList;

public class Team {

    private ArrayList<GameCharacter> characters;

    public Team() {
        characters = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {

        if (findByName(character.getName()) != null) {
            System.out.println("Character with same name already exists.");
            return;
        }

        characters.add(character);
    }

    public void removeCharacter(String name) {

        GameCharacter character = findByName(name);

        if (character != null) {
            characters.remove(character);
        } else {
            System.out.println("Character not found.");
        }
    }

    public GameCharacter findByName(String name) {

        for (GameCharacter character : characters) {

            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public void attackAll(GameCharacter target) {

        for (GameCharacter character : characters) {

            if (character.isAlive()
                    && character instanceof Attacker) {

                Attacker attacker =
                        (Attacker) character;

                int damage =
                        attacker.attack(target);

                System.out.println(
                        character.getName()
                        + " dealt "
                        + damage
                        + " damage."
                );

                if (!target.isAlive()) {
                    break;
                }
            }
        }
    }

    public void healTeam() {

        for (GameCharacter character : characters) {

            if (character.isAlive()
                    && character instanceof Supporter) {

                GameCharacter target =
                        findLowestHealthRatio();

                if (target != null) {

                    Supporter supporter =
                            (Supporter) character;

                    int restored =
                            supporter.heal(target);

                    System.out.println(
                            character.getName()
                            + " restored "
                            + restored
                            + " health to "
                            + target.getName()
                    );
                }
            }
        }
    }

    private GameCharacter findLowestHealthRatio() {

        GameCharacter lowest = null;

        double lowestRatio =
                Double.MAX_VALUE;

        for (GameCharacter character : characters) {

            if (character.isAlive()) {

                double ratio =
                        (double) character.getHealth()
                        / character.getMaxHealth();

                if (ratio < lowestRatio) {

                    lowestRatio = ratio;
                    lowest = character;
                }
            }
        }

        return lowest;
    }

    public int getTotalPower() {

        int totalPower = 0;

        for (GameCharacter character : characters) {

            if (character.isAlive()) {
                totalPower += character.calculatePower();
            }
        }

        return totalPower;
    }

    public void displayTeam() {

        for (GameCharacter character : characters) {
            System.out.println(
                    character.getCharacterInfo()
            );
        }
    }
}
