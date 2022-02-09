import com.codeborne.selenide.Selenide;
import com.geekbrains.lesson8.MainPage;
import com.geekbrains.lesson8.MoviePage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AfishaStepDefinitions {
    @Given("^Пользователь авторизовался на сайте$")
    public void userAuthorized() {
        Selenide.open("https://afisha.ru");
        new MainPage()
                .clickLoginButton()
                .switchToLoginFrame()
                .fillLogin("spartalex1993")
                .fillPassword("Test4test")
                .clickLoginButton();
    }

    @When("^Пользователь лайкает фильм$")
    public void UserLikesFilm() {
        new MoviePage().likeFilm();
    }

    @Then("^Пользователь видит плашку с сообщением об успешном добавлении фильма в избранное$")
    public void userCanSeeSuccessMessage() {
        new MoviePage().checkFilmAddedToFavourites();
    }

    @When("Пользователь кликает на фильм {string}")
    public void пользовательКликаетНаФильмFilmName(String filmName) {
        new MainPage().clickFilmByName(filmName);
    }

    @After(value = "@close_browser")
    public void after() {
        Selenide.closeWebDriver();
    }
}
