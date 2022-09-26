package webcrawler.base;

public class Winner{
    public static final String SEPARATOR = "/";

    private final int ranking;
    private final long totalMoney;
    private final long numberOfWinner;
    private final long perMoney;

    public Winner(int ranking, long totalMoney, long numberOfWinner, long perMoney) {
        this.ranking = ranking;
        this.totalMoney = totalMoney;
        this.numberOfWinner = numberOfWinner;
        this.perMoney = perMoney;
    }

    public int getRanking() {
        return ranking;
    }

    public long getTotalMoney() {
        return totalMoney;
    }

    public long getNumberOfWinner() {
        return numberOfWinner;
    }

    public long getPerMoney() {
        return perMoney;
    }

    @Override
    public String toString() {
        return ranking + SEPARATOR + totalMoney + SEPARATOR + numberOfWinner + SEPARATOR + perMoney;
    }
}