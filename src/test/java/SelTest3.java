
import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.docent.sp1.domain.Board;
import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.mapper.BoardMapper;
import com.docent.sp1.mapper.FileMapper;

import java.io.*;
import java.net.URL;
import java.util.UUID;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class SelTest3 {
    @Autowired(required = false)
    private BoardMapper boardMapper;
    @Autowired(required = false)
    private FileMapper fileMapper;
    @Autowired(required = false)
    private Board board;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

    @Test
    public  void main() throws Exception {

        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);


        ChromeOptions options = new ChromeOptions();
        // 브라우저 보이지 않기
//        options.addArguments("headless");

        WebDriver driver = new ChromeDriver(options);
        for (int i = 1; i < 3; i++) {
            driver.get(String.format("https://www.heritage.go.kr/heri/cul/culSelectViewList.do?gbn=2&pageNo=1_1_1_1&culPageNo=%d&ccbaCndt=&searchCondition=&region=1&s_kdcdArr=11&s_kdcdArr=12&s_kdcdArr=13&s_kdcdArr=15&s_ctcdArr=00&ccbaPcd1Arr=01&ccbaPcd1Arr=03&ccbaPcd1Arr=05&ccbaPcd1Arr=07&ccbaPcd1Arr=09&ccbaPcd1Arr=10&ccbaPcd1Arr=11&ccbaPcd1Arr=12&ccbaPcd1Arr=13&ccbaPcd1Arr=15&ccbaPcd1Arr=20&ccbaPcd1Arr=30&ccbaPcd1Arr=40&ccbaPcd1Arr=45&ccbaPcd1Arr=50&stCcbaAsdt=&endCcbaAsdt=&ccbaGcodeArr=00&sortType=&sortOrd=", i));
            for (int j = 1; j < 13; j++) {
                Thread.sleep(1000);
                String winHandleBefore = driver.getWindowHandle();
                driver.findElement(By.xpath(String.format("//*[@id=\"content\"]/div[3]/form[4]/div[4]/ul[2]/li[%d]", j))).click();
                Thread.sleep(1000);

                //이름
                String name = driver.findElement(By.cssSelector("#txt > div > div > div.hschDetail_tit > strong")).getText();
                String[] array =name.split("\\(");
                //소재지
                String place = driver.findElement(By.xpath("//*[@id=\"txt\"]/div/div/div[2]/table/tbody/tr[4]/td")).getText();
                //분류
                String type = driver.findElement(By.cssSelector("#txt > div > div > div.hschDetail_tit > p:nth-child(1)")).getText();
                //설명
                String introduce = driver.findElement(By.cssSelector("#tab2 > div > p.hide_exp.krExp")).getText();
                //이미지
                driver.findElement(By.cssSelector("#main_image_area > img")).click();
                Thread.sleep(5000);

                for(String winHandle : driver.getWindowHandles()){
                    driver.switchTo().window(winHandle);
                }

                String img=  driver.findElement(By.xpath("//*[@id=\"this_article_image\"]")).getAttribute("src");

                URL imgurl = new URL(img);

                InputStream inputStreamI =imgurl.openStream();

                String imguuid = UUID.randomUUID().toString();

                String saveImg = imguuid +"_"+ array[0] +".jpg";
                String originalFileName = array[0] +".jpg";
                String savePath = "C:\\ProjectFiles\\image\\";

                OutputStream imgfos = new FileOutputStream(savePath+saveImg);

                byte[] buffer = new byte[1024 * 8];
                while (true) {

                    int count = inputStreamI.read(buffer);

                    if (count == -1) {
                        break;
                    }

                    imgfos.write(buffer, 0, count);
                }
                String thumbFileName ="s_"+saveImg;
                File thumbFile = new File("C:\\ProjectFiles\\image\\"+thumbFileName);
                File saveFile = new File("C:\\ProjectFiles\\image\\"+ saveImg);

                try {
                    Thumbnails.of(saveFile)
                            .size(400,400)
                            .toFile(thumbFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }


//                String image = "/view?fileName="+thumbFileName;

                driver.close();
                driver.switchTo().window(winHandleBefore);



                //오디오
                String audio = (driver.findElement(By.xpath("//*[@id=\"audiofile\"]/source")).getAttribute("src"));

                URL audiourl = new URL(audio);

                InputStream inputStream = audiourl.openStream();

                String uuid = UUID.randomUUID().toString();

                String saveAudio = uuid +"_"+ array[0] +"audio"+".mp3";

//                String audioview = "/audio?fileName="+saveAudio;

                OutputStream fos = new FileOutputStream("C:\\ProjectFiles\\audio\\"+saveAudio);

                while (true) {

                    int count = inputStream.read(buffer);

                    if (count == -1) {
                        break;
                    }

                    fos.write(buffer, 0, count);
                }
                Board board = Board.builder()
                        .title(array[0])
                        .classify(type)
                        .introduce(introduce)
                        .image(thumbFileName)
                        .audio(saveAudio)
                        .location(place)
                        .build();

                boardMapper.insert(board);

                ImgFile imgFile= ImgFile.builder()
                        .fileName(originalFileName)
                        .uuid(imguuid)
                        .savePath(savePath)
                        .bno(board.getBno())
                        .build();

                fileMapper.insertBoardImg(imgFile);
                driver.navigate().back();
            }
        }
//        if (driver != null) {
//           driver.close();
//           driver.quit();
    }
}
