package webcrawler.base;

import java.time.LocalDate;
import java.util.Arrays;

public class ValidData {
    public static final String SEPARATOR = "\t";

    private final int round;
    private final LocalDate date;
    private final int[] numbers;
    private final int bonusNumber;
    private final Winner[] winnerList;

    public ValidData(int round, LocalDate date, int[] numbers, int bonusNumber, Winner[] winnerList) {
        this.round = round;
        this.date = date;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
        this.winnerList = winnerList;
    }

    public int getRound() {
        return round;
    }

    public LocalDate getDate() {
        return date;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Winner[] getWinnerList() {
        return winnerList;
    }

    @Override
    public String toString() {
        return round + SEPARATOR + date.toString() + SEPARATOR + Arrays.toString(numbers) + SEPARATOR + bonusNumber + SEPARATOR + Arrays.toString(winnerList) + "\n";
    }
}