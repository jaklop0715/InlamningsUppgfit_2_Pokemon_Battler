import com.sun.source.tree.AnnotatedTypeTree;

import java.util.Random;

public class Battle {

    public Pokemon getFaster (Pokemon first, Pokemon second) {

        if (first.getSpeed() >= second.getSpeed()) {
            return first;
        }
        return second;
    }
    private Random random = new Random();

    public boolean attackHits (Attack attack) {

        int roll = random.nextInt(100) + 1;

        if (roll > attack.getAccuracy()){
            return false;
        }
        return true;
    }
    public int calculateDamage(Attack attack) {

        int percent = random.nextInt(16) + 85;

        int damage = attack.getBaseDamage() * percent / 100;
        return damage;
    }
    public void doAttack (Pokemon attacker, Pokemon defender, Attack attack) {

        System.out.println(attacker.getName() + "använder" + attack.getName() + "!");

        if (attackHits(attack)) {

            int damage = calculateDamage(attack);
            defender.takeDamage(damage);

            System.out.println("Attacken träffar och gör " + damage + "skada!");
            System.out.println(defender.getName() + "har " + defender.getCurrentHP() + "/" + defender.getMaxHP() + "HP kvar.");

            if (defender.isFainted()) {
                System.out.println(defender.getName() + "blev besegrad!");
            }
        } else {
            System.out.println("Attacken missade!");
        }

    }
}
