package webcrawler.base;

public class Winner{
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
        return "Winner{" +
                "ranking=" + ranking +
                ", totalMoney=" + totalMoney +
                " 원, numberOfWinner=" + numberOfWinner +
                " 명, perMoney=" + perMoney +
                " 원}";
    }
}