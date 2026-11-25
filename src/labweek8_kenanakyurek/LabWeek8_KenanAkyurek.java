/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labweek8_kenanakyurek;

/**
 *
 * @author akyur LabWeek8_KenanAkyurek
 */
public class LabWeek8_KenanAkyurek {

    public static void main(String[] args) {

        Team team = new Team();

        Warrior warrior =
                new Warrior(
                        "Aras",
                        10,
                        180,
                        20
                );

        Mage mage =
                new Mage(
                        "Merlin",
                        12,
                        140,
                        100
                );

        Healer healer =
                new Healer(
                        "Luna",
                        9,
                        130,
                        30
                );

        team.addCharacter(warrior);
        team.addCharacter(mage);
        team.addCharacter(healer);

        // Duplicate name test
        team.addCharacter(
                new Warrior(
                        "Aras",
                        5,
                        100,
                        10
                )
        );

        // Invalid level test
        Mage invalidMage =
                new Mage(
                        "InvalidMage",
                        150,
                        100,
                        50
                );

        Warrior golem =
                new Warrior(
                        "Golem",
                        20,
                        350,
                        30
                );

        for (int round = 1;
                round <= 2;
                round++) {

            System.out.println(
                    "\n===== ROUND "
                    + round
                    + " ====="
            );

            team.attackAll(golem);

            if (golem.isAlive()) {

                golem.attack(warrior);
                golem.attack(mage);
                golem.attack(healer);
            }

            team.healTeam();

            System.out.println("\nTEAM:");
            team.displayTeam();

            System.out.println("\nENEMY:");
            System.out.println(
                    golem.getCharacterInfo()
            );

            if (!golem.isAlive()) {

                System.out.println(
                        "Golem defeated."
                );

                break;
            }
        }

        System.out.println("\nSEARCH:");

        GameCharacter found =
                team.findByName("Merlin");

        if (found != null) {

            System.out.println(
                    found.getCharacterInfo()
            );
        }

        System.out.println("\nREMOVE:");

        team.removeCharacter("Aras");

        System.out.println("\nFINAL TEAM:");

        team.displayTeam();

        System.out.println(
                "Total Power: "
                + team.getTotalPower()
        );
    }
}
