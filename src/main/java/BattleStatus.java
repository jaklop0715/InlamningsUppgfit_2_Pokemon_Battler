

public class BattleStatus {
    private int wins;
    private int losses;

    public void addWin() {
        wins++;
    }

    public void addLoss() {
        losses++;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTotal() {
        return wins + losses;
    }
}
