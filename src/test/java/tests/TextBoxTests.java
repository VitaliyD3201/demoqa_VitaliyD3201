package tests;


import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Tall");
        $("#userEmail").setValue("alex45889@egorov.com");
        $("[for='gender-radio-3']").click();
        $("#userNumber").setValue("9991199953");
        $("#dateOfBirthInput").setValue("25 Jul 1999");
        $("#subjectsInput").val("Physics").pressEnter();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("photo_2022-06-27_11-31-08.jpg");
        $("#currentAddress-label").setValue("Some street 1");
        $("#state").scrollTo().click();
        $("#react-select-3-input").val("Haryana").pressEnter();
        $("#city").click();
        $("#react-select-4-input").val("Karnal").pressEnter();
        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Alex Tall"),
                text("alex45889@egorov.com"),
                text("Other"),
                text("9991199953"),
                text("25 Jul 1999"),
                text("Physics"),
                text("Music"),
                text("photo_2022-06-27_11-31-08.jpg"),
                text("Some street 1"),
                text("Haryana Karnal"));
    }
}