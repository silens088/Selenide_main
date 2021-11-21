package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SearchSelenideRepoPageWiki {


    @BeforeAll
    static void beforeAll() {
        //Configuration.startMaximized = true;
        Configuration.browserSize = "1366x768";
    }

    @Test
    void shouldFindInSelenideRepoInGithubPageSoftassertion() {

        //open gitHub page
        open("https://github.com/");

        //ввести в поле поиска селенид - нажать искать
        $("[data-test-selector=nav-search-input]").setValue("selenide").pressEnter(); //chain

        //переходим по ссылке selenide
        //$$(".repo-list li").get(0).$("a").click();
        $$(".repo-list li a").first().click(); //сокращенный вариант

        //переходим на страницу Wiki
        $("#wiki-tab").click();

        //проверяем что на странице Wiki есть текст SoftAssertion
        $("#wiki-body").shouldHave(text("Soft assertions")).shouldBe(visible);

        //открываем страницу SoftAssertion
        $(".markdown-body").$(byText("Soft assertions")).click();

        //роверяем что внутри есть пример кода для JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class")).click();

        sleep(5000);
    }
}

