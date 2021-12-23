package mk.sedc.utiles.data;

import com.github.javafaker.Faker;

public class RegistrationData {

    public static String randomEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String email = randomEmail();
    public static String firstName = "Emilija";
    public static String lastName = "Spasova";
    public static String password = "pasvord1234";
    public static int dayOfBirth = 5;
    public static int monthOfBirth = 3;
    public static int yearOfBirth = 1996;
    public static String addressFirstName = "Emilija";
    public static String addressLastName = "Spasova";
    public static String address = "Finska 20";
    public static String city = "Skopje";
    public static String state = "Texas";
    public static int zipCode = 10000;
    public static int number = 76459877;
}
