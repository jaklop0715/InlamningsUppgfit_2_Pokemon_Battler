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

}
