package app;

import com.github.javafaker.Faker;

public class AppConfig {
    public static final String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    public static final String registerUrl = "https://parabank.parasoft.com/parabank/register.htm";
    private static Faker faker = new Faker();
    public static final String userName = faker.name().username();
    public static final String password = faker.internet().password();
    public static final String firstName = faker.name().firstName();
    public static final String  lastName = faker.name().lastName();
    public static final String  address = faker.address().streetAddress();
    public static final String   city = faker.address().cityName();
    public static final String   state = faker.address().state();
    public static final String   zipCode = faker.code().asin();
    public static final String   phone = faker.phoneNumber().phoneNumber();
    public static final String   ssn = faker.code().ean8();
}
