package Lesson6;

import com.geekbrains.lesson6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.Iterator;

@Story("Работа с фильмами")
public class AfishaPageObjectTest {
    WebDriver driver;
    //EventFiringWebDriver eventFiringWebDriver;
    private final static String AFISHA_URL = "https://afisha.ru";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        //driver = new ChromeDriver();
        //eventFiringWebDriver = new EventFiringWebDriver(new ChromeDriver());
        //eventFiringWebDriver.register(new CustomLoggerThirdSelenium());   3 selenium
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        driver.get(AFISHA_URL);
    }

    @Test
    @Feature("Избранное")
    @Description("Проверка добавления в избранное фильма по имени")
    void likeRandomFilmTest() {
        new MainPage(driver)
                .clickLoginButton()
                .switchToLoginFrame()
                .fillLogin("tqggcri4gf1l@mail.com")
                .fillPassword("123Mail123")
                .clickLoginButton()
                .clickFilmByName("Leta")
                .likeFilm()
                .checkFilmAddedToFavourites();
    }

    @AfterEach
    void killDriver() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logEntries.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Лог браузера:", iterator.next().getMessage());
        }

        for (LogEntry log: logEntries) {
            Allure.addAttachment("Лог браузера:", log.getMessage());
        }
        driver.quit();
    }
}
