package tests;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class TexBoxTestsFaker extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .setDateOfBirth(testData.strDayOfBirth, testData.monthOfBirth, testData.strYearOfBirth)
                .setData(testData.subjectsInput)
                .setHobbies(testData.hobbies)
                .setUploadPicture()
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city)
                .submit()
        ;

        //заполняем форму и отправляем ее

        registrationPage.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber)
                .checkResult("Date of Birth", testData.strDayOfBirth + "\n" +
                        testData.monthOfBirth + "," +
                        testData.strYearOfBirth)
                .checkResult("Subjects", testData.subjectsInput)
                .checkResult("Hobbies",testData.hobbies)
                .checkResult("Picture",testData.nameForPicture)
                .checkResult("Address",testData.currentAddress)
                .checkResult("State and City",testData.state + "\n" + testData.city);

    }
    @Test
    void fillFormTestMinimal() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.userNumber)
                .submit();

        //заполняем форму и отправляем ее

        registrationPage.checkResult("Student Name", testData.firstName + "\n" + testData.lastName)
                .checkResult("Student Email", testData.userEmail)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.userNumber);


    }



    @Test
    void negativeScenario()
    {
        registrationPage.openPage()
                .submit();

        registrationPage.checkResult();

    }

}