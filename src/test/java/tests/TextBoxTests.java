package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    File image = new File("src/test/resources/Test1.PNG");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000; // default 4000
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("#submit").scrollIntoView(true);
        //заполняем форму и отправляем ее
        $("#firstName").setValue("Alex");
        $("#lastName").setValue("Tall");
        $("#userEmail").setValue("Alex@mail.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("9994445566");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("9");
        $(".react-datepicker__year-select").selectOptionByValue("1999");
        $(".react-datepicker__day--020:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("e");
        $(byText("Economics")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Test1.png");
        $("#currentAddress").setValue("Russia");
        $("#state").click();
        $(byText("Rajasthan")).click();
        $("#city").click();
        $(byText("Jaiselmer")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name"))
                .parent().shouldHave(text("Alex Tall"));
        $(".table-responsive").$(byText("Student Email"))
                .parent().shouldHave(text("Alex@mail.ru"));
        $(".table-responsive").$(byText("Gender"))
                .parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile"))
                .parent().shouldHave(text("9994445566"));
        $(".table-responsive").$(byText("Date of Birth"))
                .parent().shouldHave(text("20 October,1999"));
        $(".table-responsive").$(byText("Subjects"))
                .parent().shouldHave(text("Economics"));
        $(".table-responsive").$(byText("Hobbies"))
                .parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Address"))
                .parent().shouldHave(text("Russia"));
        $(".table-responsive").$(byText("State and City"))
                .parent().shouldHave(text("Rajasthan Jaiselmer"));
        $(".table-responsive").$(byText("Picture"))
                .parent().shouldHave(text("Test1.PNG"));


    }
}