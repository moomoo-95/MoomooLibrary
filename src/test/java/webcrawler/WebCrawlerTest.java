package webcrawler;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import webcrawler.base.PlainData;
import webcrawler.base.ValidData;
import webcrawler.base.Winner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
public class WebCrawlerTest {
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    private static final String WEB_DRIVER_PATH = "./src/main/resources/driver/chromedriver";

    private static final String NOT_NUMBER = "[^0-9]";

    private ArrayList<ValidData> dataList = new ArrayList<>();


    @Test
    public void webCrawlerTest() {
        WebDriver driver;
        ArrayList<PlainData> elements = new ArrayList<>();
        int count = 200;
        String url1 = "https://dhlottery.co.kr/gameResult.do?method=byWin&drwNo=";
        String url2 = "&dwrNoList=";

        // WebDriver 경로 설정
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        // 브라우저 띄우지 않고 실행
        options.addArguments("headless");
        // 이미지 로딩 false
        options.addArguments("--blink-settings=imagesEnabled=false");
        // 팝업 차단 해제
        options.addArguments("--disable-popup-blocking");
        // secret mode
        options.addArguments("incognito");

        driver = new ChromeDriver(options);

        try {
            while (count < 200 + 3) {
                count++;
                String query = url1 + count + url2 + count;
                driver.get(query);
                Thread.sleep(200);
                //driver.findElement(By.xpath("/html/body/div[3]/section/div/div[2]")
                PlainData plainData = new PlainData(
                        count,
                        driver.findElement(By.className("desc")).getText(),
                        driver.findElement(By.className("nums")).getText(),
                        driver.findElement(By.tagName("table")).getText()
                );
                elements.add(plainData);
            }
        } catch (Exception e) {
            log.error("ChromeCrawler.crawling ", e);
        } finally {
            driver.close();
        }

        elements.forEach( element -> plainToParseData(element));

        dataList.forEach( validData -> {
            log.debug("=============================================");
            log.debug("rnd : {}", validData.getRound());
            log.debug("dat : {}", validData.getDate());
            log.debug("num : {}", validData.getNumbers());
            log.debug("bnm : {}", validData.getBonusNumber());
            log.debug("wnr : {}", validData.getWinnerList());
        });
    }

    public void plainToParseData(PlainData plainData) {

        String[] plainDates = plainData.getDate().split(" ");
        int year = Integer.parseInt(plainDates[0].replaceAll(NOT_NUMBER,""));
        int month = Integer.parseInt(plainDates[1].replaceAll(NOT_NUMBER,""));
        int day = Integer.parseInt(plainDates[2].replaceAll(NOT_NUMBER,""));
        LocalDate date = LocalDate.of(year, month, day);

        int[] numbers = new int[6];
        int bonusNumber;
        String[] plainNumbers = plainData.getData().split("\n");
        for(int idx = 1; idx < 7; idx++) {
            numbers[idx-1] = Integer.parseInt(plainNumbers[idx]);
        }
        bonusNumber = Integer.parseInt(plainNumbers[8]);

        Winner[] winners = new Winner[5];
        String[] plainWinners = plainData.getRanking().split("\n");
        for(int idx = 1; idx < 7; idx++) {
            if(idx == 3) idx++;
            String[] plainWinner = plainWinners[idx].split(" ");
            int ranking = Integer.parseInt(plainWinner[0].replaceAll(NOT_NUMBER,""));
            long totalMoney = Long.parseLong(plainWinner[1].replaceAll(NOT_NUMBER,""));
            long numberOfWinner = Long.parseLong(plainWinner[2].replaceAll(NOT_NUMBER,""));
            long perMoney = Long.parseLong(plainWinner[3].replaceAll(NOT_NUMBER,""));

            winners[ranking-1] = new Winner(ranking, totalMoney, numberOfWinner, perMoney);
        }

        ValidData validData = new ValidData(
                plainData.getRound(),
                date,
                numbers,
                bonusNumber,
                winners
                );
        dataList.add(validData);
    }


}
