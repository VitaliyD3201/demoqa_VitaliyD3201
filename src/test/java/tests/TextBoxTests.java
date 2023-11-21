package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Tall")
                .setEmail("Alex@mail.ru")
                .setGender("Other")
                .setUserNumber("9994445566")
                .setDateOfBirth("20", "July", "2008")
                .setData()
                .setHobbies("Sports")
                .setUploadPicture()
                .setCurrentAddress("Russia")
                ;

        //заполняем форму и отправляем ее

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
                .parent().shouldHave(text("20 July,2008"));
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