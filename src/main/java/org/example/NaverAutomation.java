package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NaverAutomation {
    public static void main(String[] args) {
      try{
          // 크롬 드라이버 경로 설정
          System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
          // 크롬 옵션 설정
          ChromeOptions options = new ChromeOptions();
          options.addArguments("--start-maximized"); //크롬 브라우저를 최대화.

          // WebDriver 초기화
          WebDriver driver = new ChromeDriver(options);

          // 웹 페이지 열기
          // 대상 웹페이지 URL로 변경, Selenium Webdriver를 사용하여
          // 네이버 홈페이지(또는 원하는 다른 웹페이지)를 엽니다.
          driver.get("https://www.naver.com");

          // 웹 페이지가 완전히 로드될 때까지 대기 (예: 10초)
          // implicitlyWait 메서드를 이용하여 웹 페이지가 완전히 로드될 때까지 최대 10초간 대기.
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          // 원하는 웹 페이지의 특정 요소를 찾아서 이미지로 캡쳐 (예: id="targetElement")
          // By.id("targetElement")를 사용하여 웹 페이지에서 targetElement라는 ID를 가진 요소를 찾습니다.
          WebElement targetElement = driver.findElement(By.id("targetElement"));

          // JavaScript를 사용하여 요소의 위치와 크기를 가져욤
          int x = targetElement.getLocation().getX();
          int y = targetElement.getLocation().getY();
          int width = targetElement.getSize().getWidth();
          int height = targetElement.getSize().getHeight();

          // JavaScript를 사용하여 스크롤 위치를 설정 (요소가 보이도록 스크롤)
          // JavaScript를 사용하여 페이지를 스크롤하여 원하는 요소가 화면에 보이도록 합니다.
          JavascriptExecutor js = (JavascriptExecutor) driver;
          js.executeScript("window.scrollTo(" + x + "," + y + ")");

          // 현재 탭 핸들 저장
          String firstTab = driver.getWindowHandle();
          //새 탭 열기
          ((JavascriptExecutor) driver).executeScript("window.open();");

          //모든 탭의 핸들 가져오기
          Set<String> handles = driver.getWindowHandles();

          // 새로 열린 탭을 찾아서 활성화
          for (String handle : handles) {
              if(!handle.equals(firstTab)) {
                  driver.switchTo().window(handle);
              }
          }

          //웹 페이지 열기
          driver.get("https://html2img.com/?sourceUrl=https://www.naver.com&width=" + width + "&height=" + height + "&x=" + x + "&y=" + y);

          // 네이버 로그인 버튼을 찾아 클릭
          WebElement loginButton = driver.findElement(By.linkText("로그인"));
          loginButton.click();

          // 다른 작업 수행 가능

          // 두 번째 탭에서 작업 완료 후 첫 번째 탭으로 전환
          driver.switchTo().window(firstTab);
          // 브라우저 닫기
          driver.quit();
      } catch (Exception e) {
          e.printStackTrace();
      }
    }
}
