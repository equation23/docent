import com.docent.sp1.domain.DAdmin;
import com.docent.sp1.domain.ImgFile;
import com.docent.sp1.domain.Notice;
import com.docent.sp1.mapper.FileMapper;
import com.docent.sp1.mapper.NoticeMapper;
import com.docent.sp1.service.FileService;
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

import java.util.UUID;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class Tests {
    @Autowired(required = false)
    private NoticeMapper noticeMapper;
    @Autowired(required = false)
    private FileMapper fileMapper;
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    public static final String WEB_DRIVER_PATH = "C:\\chromedriver\\chromedriver.exe"; // 드라이버 경로

    @Test
    public void main() throws Exception {

        for (int i = 0; i < 50; i++) {


            Notice notice = Notice.builder()
                    .dname("admin"+i)
                    .content("Notice Test_"+i)
                    .title("Notice Test--"+i)
                    .build();

            log.info(notice.getBno());



            noticeMapper.noticeInsert(notice);


            ImgFile imgFile = ImgFile.builder()
                    .fileName("aaa")
                    .img(true)
                    .uuid(UUID.randomUUID().toString() + "_aaa.jpg")
                    .savePath("C:\\projectFiles\\boardImage\\").build();
            fileMapper.insertImg(imgFile);

        }
    }

    }

