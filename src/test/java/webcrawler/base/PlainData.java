package webcrawler.base;

public class PlainData{
    private final int round;
    private final String date;
    private final String data;
    private final String ranking;

    public PlainData(int round, String date, String data, String ranking) {
        this.round = round;
        this.date = date;
        this.data = data;
        this.ranking = ranking;
    }

    public int getRound() {
        return round;
    }

    public String getDate() {
        return date;
    }

    public String getData() {
        return data;
    }

    public String getRanking() {
        return ranking;
    }
}