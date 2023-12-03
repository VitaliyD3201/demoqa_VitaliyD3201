package util;

import com.github.javafaker.Faker;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    static public Faker faker = new Faker();

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        return faker.options().option(genders);
    }

    public static String getRandomMonth() {
        String[] months = {"January", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"};

        return faker.options().option(months);
    }

    public static String getHobbies() {
        String[] hobbies =  {"Sports", "Reading", "Music"};
        return faker.options().option(hobbies);
    }

    public static String getRandomSubjects() {
        String[] genders = {"Maths", "Accounting", "Arts", "Social Studies","Biology", "Physics", "Chemistry",
                "Computer Science", "Economics", "Civics", "Hindi", "English","History"};

        return faker.options().option(genders);
    }

    public static String getRandomState() {
        String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        return faker.options().option(states);
    }
    public static String getRandomCity(String city) {
        String[] cityForNCR = {"Delhi", "Gurgaon", "Noida"};
        String[] cityForUttarPradesh = {"Agra", "Lucknow", "Merrut"};
        String[] cityForUttarHaryana = {"Karnal", "Panipat"};
        String[] cityForUttarRajasthan = {"Jaipur", "Jaiselmer"};

        if (city=="NCR")
            return faker.options().option(cityForNCR);
        else
        if (city=="Uttar Pradesh")
            return faker.options().option(cityForUttarPradesh);
        else
        if (city=="Haryana")
            return faker.options().option(cityForUttarHaryana);
        else
            return faker.options().option(cityForUttarRajasthan);
    }

}