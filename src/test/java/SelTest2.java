
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.docent.sp1.mapper.BoardMapper;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class SelTest2 {
    @Autowired(required = false)

    private BoardMapper boardMapper;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

    public static void main(String[] args) throws Exception {

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        // 브라우저 보이지 않기
        // options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        for (int i = 1; i < 2; i++) {
            driver.get(String.format("https://www.heritage.go.kr/heri/cul/culSelectViewList.do?gbn=2&pageNo=1_1_1_1&culPageNo=%d&ccbaCndt=&searchCondition=&region=1&s_kdcdArr=11&s_kdcdArr=12&s_kdcdArr=13&s_kdcdArr=15&s_ctcdArr=00&ccbaPcd1Arr=01&ccbaPcd1Arr=03&ccbaPcd1Arr=05&ccbaPcd1Arr=07&ccbaPcd1Arr=09&ccbaPcd1Arr=10&ccbaPcd1Arr=11&ccbaPcd1Arr=12&ccbaPcd1Arr=13&ccbaPcd1Arr=15&ccbaPcd1Arr=20&ccbaPcd1Arr=30&ccbaPcd1Arr=40&ccbaPcd1Arr=45&ccbaPcd1Arr=50&stCcbaAsdt=&endCcbaAsdt=&ccbaGcodeArr=00&sortType=&sortOrd=", i));
            for (int j = 1; j < 3; j++) {
                Thread.sleep(1000);
                String winHandleBefore = driver.getWindowHandle();
                Thread.sleep(1000);
                driver.findElement(By.xpath(String.format("//*[@id=\"content\"]/div[3]/form[4]/div[4]/ul[2]/li[%d]", j))).click();
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("#main_image_area > img")).click();
                Thread.sleep(5000);
                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                }
                String img=  driver.findElement(By.xpath("//*[@id=\"this_article_image\"]")).getAttribute("src");
                System.out.println(img);
                driver.close();
                driver.switchTo().window(winHandleBefore);
                driver.navigate().back();
            }
        }
    }
}