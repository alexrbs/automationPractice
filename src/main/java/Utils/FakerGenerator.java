package Utils;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerGenerator {

    private static Faker faker = new Faker(new Locale("en-US"));

    public static String getFirstName(){
        return faker.name().firstName();
    }

    public static String getLastName(){
        return faker.name().lastName();
    }

    public static String getPhoneNumber(){
        return faker.phoneNumber().phoneNumber();
    }

    public static String getMobilePhoneNumber(){
        return faker.phoneNumber().cellPhone();
    }

    public static String getEmailAddress(){
        return faker.internet().safeEmailAddress();
    }

    public static String getUserPassword(){
        return faker.internet().password();
    }

    public static String getHomeAddress(){
        return faker.address().streetName();
    }

    public static String getCityAddress(){
        return faker.address().cityName();
    }

    public static String getPostalCode(){
        return faker.address().zipCode();
    }


}
