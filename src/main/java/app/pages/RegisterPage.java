package app.pages;

import com.codeborne.selenide.SelenideElement;
import helpers.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static app.AppConfig.*;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage extends AbstractPage {
    private SelenideElement firstNameField = $x("//input[@name='customer.firstName']");
    private SelenideElement lastNameField = $x("//input[@name='customer.lastName']");
    private SelenideElement addressField = $x("//input[@name='customer.address.street']");
    private SelenideElement cityField = $x("//input[@name='customer.address.city']");
    private SelenideElement stateField = $x("//input[@name='customer.address.state']");
    private SelenideElement zipCodeField = $x("//input[@name='customer.address.zipCode']");
    private SelenideElement phoneField = $x("//input[@name='customer.phoneNumber']");
    private SelenideElement ssnField = $x("//input[@name='customer.ssn']");
    private SelenideElement userNameField = $x("//input[@name='customer.username']");
    private SelenideElement passwordField = $x("//input[@name='customer.password']");
    private SelenideElement confirmField = $x("//input[@name='repeatedPassword']");
    private SelenideElement registerButton = $x("//input[@value='Register']");

    public RegisterPage(String pageUrl) {
        super(pageUrl);
    }

    @Step("Регистрация нового пользователя")
    public void register() {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        addressField.setValue(address);
        cityField.setValue(city);
        stateField.setValue(state);
        zipCodeField.setValue(zipCode);
        phoneField.setValue(phone);
        ssnField.setValue(ssn);
        userNameField.setValue(userName);
        passwordField.setValue(password);
        confirmField.setValue(password);

        registerButton.click();
        Driver.waitForMessage(By.xpath("//p[text()='Your account was created successfully. You are now logged in.']"),
                "Your account was created successfully. You are now logged in.");
    }
}
