package com.geekbrains.lesson8;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;


public class MoviePage {
    private SelenideElement likeButton = $(By.xpath("//section[@data-test='PAGE-SECTION TITLE-SECTION']//button[@data-test='BUTTON FAVORITE']"));

    @Step("Добавить фильм в избранное")
    public MoviePage likeFilm() {
        likeButton.click();
        return this;
    }

    private SelenideElement addedToFavouritesElement = $(By.xpath("//div[.='Добавлено в избранное']"));

    @Step("Проверить что фильм добавился в избранное")
    public MoviePage checkFilmAddedToFavourites() {
        assertThat(addedToFavouritesElement, isDisplayed());
        addedToFavouritesElement.shouldBe(Condition.visible, Duration.ofSeconds(6));
        return this;
    }
}
