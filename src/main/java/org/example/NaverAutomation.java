package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverAutomation {
    public static void main(String[] args) {
        // 크롬 드라이버 경로 설정
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");

        // 크롬 브라우저 열기
        WebDriver driver = new ChromeDriver();

        // 네이버 페이지로 이동
        driver.get("https://www.naver.com");

        // 네이버 로그인 버튼을 찾아 클릭
        WebElement loginButton = driver.findElement(By.linkText("로그인"));
        loginButton.click();

        // 다른 작업 수행 가능

        // 브라우저 닫기
        driver.quit();
    }
}
