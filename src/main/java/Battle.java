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
    public Attack chooseCpuAttack (Pokemon cpu) {

        int index = random.nextInt(cpu.getAttacks().size());

        return cpu.getAttacks().get(index);
    }

    public Attack choosePlayerAttack (Pokemon player) {

        System.out.println("Välj attack: ");

        for (int i = 0; i < player.getAttacks().size(); i++){
            System.out.println((i + 1) + ". " + player.getAttacks().get(i));
        }
        int choice = InputHelper.readIntInRange(1, player.getAttacks().size());
        return player.getAttacks().get(choice - 1);
    }

    public void fight (Pokemon player, Pokemon cpu) {

        boolean playerFirst = getFaster(player, cpu) == player;

        while (player.isFainted() == false && cpu.isFainted() == false) {

            if (playerFirst){

                playerTurn(player, cpu);

                if (cpu.isFainted() == false){
                    cpuTurn(cpu, player);
                }
            } else {

                cpuTurn(cpu, player);

                if (player.isFainted() == false) {
                    playerTurn(player, cpu);
                }
            }


        }
    }
    public void playerTurn (Pokemon player, Pokemon cpu) {
        Attack attack =choosePlayerAttack(player);

        doAttack(player, cpu, attack);
    }

    public void cpuTurn (Pokemon cpu, Pokemon player){
        Attack attack = chooseCpuAttack(player);

        doAttack(cpu, player, attack);
    }
}
