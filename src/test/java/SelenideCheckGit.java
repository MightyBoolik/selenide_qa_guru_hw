import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideCheckGit {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }
    @Test
    void selenideInGitTest(){
        open("https://github.com/");
        //Открыть страницу гитхаб
        $("[name=q]").val("Selenide").pressEnter();
        //Ввести значение"Selenide" в поле поиска и нажать Enter
        $(".repo-list a").click();
        //Выбрать "Selenide/selenide"в списке репозитариев
        $(byText("Wiki")).click();
        //Открыть раздел"Wiki"
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        //Проверить наличие страницы"SoftAssertions"в "Pages"
        $$(".internal").find(text("Soft assertions")).click();
        //Открыть страницу "SoftAssertions"
        $$("#wiki-body li").shouldHave(itemWithText("Using JUnit5 extend test class:"));
        //Проверка наличия на странице примера кода для JUnit5




    }

}
