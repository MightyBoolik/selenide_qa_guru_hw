import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideCheckGit {
    @BeforeAll
    static void setup(){
        Configuration.startMaximized = true;
    }
    @Test
    void SelenideInGitTest(){
        open("https://github.com/");//Открыть страницу гитхаб
        $("[name=q]").val("Selenide").pressEnter();//Ввести значение"Selenide" в поле поиска и нажать Enter
        $$("ul.repo-list li").get(0).$("a").click();//Выбрать "Selenide/selenide"в списке репозитариев
        $(byText("Wiki")).click();//Открыть раздел"Wiki"
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));//Проверить наличие страницы"SoftAssertions"в "Pages"
        $$("ul.m-0 li").get(14).click();//Открыть страницу "SoftAssertions"



    }

}
