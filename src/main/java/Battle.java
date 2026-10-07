

public class Battle {
    public Pokemon getFaster (Pokemon first, Pokemon second) {

        if (first.getSpeed() > second.getSpeed()) {
            return first;
        }
        return second;
    }
}
