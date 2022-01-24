package com.geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://afisha.ru");
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));

        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("tqggcri4gf1l");
        driver.findElement(By.id("password")).sendKeys("123Mail123");
        webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@mail.ru"));

        driver.findElement(By.xpath("//span[.='Войти']/..")).click();
        Thread.sleep(20000);

    }
}
