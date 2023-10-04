package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

public class CaptureService {
    public static String capture(CaptureRequest request){

        try{
            // WebDriver 경로 설정
            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

            // Chrome 브라우저 실행
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");  // 브라우저를 최대화하여 실행
            WebDriver driver = new ChromeDriver(options);

            // 사용자가 요청한 페이지 열기
            driver.get(request.getSourceUrl());

            // 전체 페이지의 스크린샷을 캡처
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            BufferedImage fullImg = ImageIO.read(screenshot);

            // 사용자로부터 입력받은 영역만 캡처
            BufferedImage eleScreenshot = fullImg.getSubimage(request.getX(), request.getY(), request.getWidth(), request.getHeight());
            ImageIO.write(eleScreenshot, "png", screenshot);

            String capturedPngFileName = "screenshot.png";
            File screenshotLocation = new File(capturedPngFileName);
            ImageIO.write(eleScreenshot, "png", screenshotLocation);

            // 캡쳐된 이미지를 새 탭에서 열기
            String newTab = "window.open('about:blank','_blank');";
            ((JavascriptExecutor) driver).executeScript(newTab);
            driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
            driver.get("file://" + screenshotLocation.getAbsolutePath());
//            driver.quit();

            return capturedPngFileName;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
