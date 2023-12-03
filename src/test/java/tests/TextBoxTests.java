package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



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
                .setData("Economics")
                .setHobbies("Sports")
                .setUploadPicture("Test1.png")
                .setCurrentAddress("Russia")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .submit()
                ;

        //заполняем форму и отправляем ее

        registrationPage.checkResult("Student Name", "Alex Tall")
                .checkResult("Student Email", "Alex@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9994445566")
                .checkResult("Date of Birth", "20 July,2008")
                .checkResult("Subjects", "Economics")
                .checkResult("Hobbies", "Hobbies")
                .checkResult("Picture", "Test1.PNG")
                .checkResult("Address", "Russia")
                .checkResult("State and City", "Rajasthan Jaiselmer");

    }
    @Test
    void fillFormTestMinimal() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Tall")
                .setEmail("Alex@mail.ru")
                .setGender("Other")
                .setUserNumber("9994445566")
                .submit()
        ;

        //заполняем форму и отправляем ее

        registrationPage.checkResult("Student Name", "Alex Tall")
                .checkResult("Student Email", "Alex@mail.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9994445566");


    }



    @Test
    void negativeScenario()
    {
        registrationPage.openPage()
                .submit();

        registrationPage.checkResult();

    }

}