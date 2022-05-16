import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.docent.sp1.domain.Board;
import com.docent.sp1.mapper.BoardMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class Tests {
    @Autowired(required = false)
    private BoardMapper boardMapper;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

    @Test
    public void main() throws Exception {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        // 브라우저 보이지 않기
        // options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
//        driver.get("https://www.heritage.go.kr/heri/cul/culSelectViewList.do?gbn=2&pageNo=1_1_1_1&culPageNo=1&ccbaCndt=&searchCondition=&region=1&s_kdcdArr=11&s_kdcdArr=12&s_kdcdArr=13&s_kdcdArr=15&s_ctcdArr=00&ccbaPcd1Arr=01&ccbaPcd1Arr=03&ccbaPcd1Arr=05&ccbaPcd1Arr=07&ccbaPcd1Arr=09&ccbaPcd1Arr=10&ccbaPcd1Arr=11&ccbaPcd1Arr=12&ccbaPcd1Arr=13&ccbaPcd1Arr=15&ccbaPcd1Arr=20&ccbaPcd1Arr=30&ccbaPcd1Arr=40&ccbaPcd1Arr=45&ccbaPcd1Arr=50&stCcbaAsdt=&endCcbaAsdt=&ccbaGcodeArr=00&sortType=&sortOrd=");

        // 브라우저 닫기
        if (driver != null) {
            // driver.close();
            // driver.quit();
        }

        Thread.sleep(1000);

//
//        List<WebElement> list = driver.findElements(By.className("img-wrap"));
//
//        System.out.println(list);
//
//        list.forEach(webElement -> {
//            System.out.println(webElement.findElement(By.cssSelector("a img")).getAttribute("src"));
//        });

        for (int i = 1; i < 20; i++) {
            driver.get(String.format("https://www.heritage.go.kr/heri/cul/culSelectViewList.do?gbn=2&pageNo=1_1_1_1&culPageNo=%d&ccbaCndt=&searchCondition=&region=1&s_kdcdArr=11&s_kdcdArr=12&s_kdcdArr=13&s_kdcdArr=15&s_ctcdArr=00&ccbaPcd1Arr=01&ccbaPcd1Arr=03&ccbaPcd1Arr=05&ccbaPcd1Arr=07&ccbaPcd1Arr=09&ccbaPcd1Arr=10&ccbaPcd1Arr=11&ccbaPcd1Arr=12&ccbaPcd1Arr=13&ccbaPcd1Arr=15&ccbaPcd1Arr=20&ccbaPcd1Arr=30&ccbaPcd1Arr=40&ccbaPcd1Arr=45&ccbaPcd1Arr=50&stCcbaAsdt=&endCcbaAsdt=&ccbaGcodeArr=00&sortType=&sortOrd=", i));
            Thread.sleep(1000);
            for (int j = 1; j < 13; j++) {
                Thread.sleep(1000);
                driver.findElement(By.xpath(String.format("//*[@id=\"content\"]/div[3]/form[4]/div[4]/ul[2]/li[%d]", j))).click();

                //소재지
                String place = driver.findElement(By.xpath("//*[@id=\"txt\"]/div/div/div[2]/table/tbody/tr[4]/td")).getText();


                //분류
                String type = driver.findElement(By.cssSelector("#txt > div > div > div.hschDetail_tit > p:nth-child(1)")).getText();


                //이름
                String name = driver.findElement(By.cssSelector("#txt > div > div > div.hschDetail_tit > strong")).getText();
                String[] array =name.split("\\(");


                //설명
                Thread.sleep(1000);
                String introduce = driver.findElement(By.cssSelector("#tab2 > div > p.hide_exp.krExp")).getText();


                //이미지 파일
                String img = driver.findElement(By.xpath("//*[@id=\"main_image_area\"]/img")).getAttribute("src");

                //오디오 파일 링크
                String audio = (driver.findElement(By.xpath("//*[@id=\"audiofile\"]/source")).getAttribute("src"));


                Board board = Board.builder()
                        .title(array[0])
                        .classify(type)
                        .introduce(introduce)
                        .image(img)
                        .audio(audio)
                        .location(place)
                        .build();

                boardMapper.insert(board);

                log.info(board);
                //뒤로가기
                driver.navigate().back();
                Thread.sleep(1000);


            }
        }//페이지 넘기기
    }
}


