package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import manager.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ErrorScreen extends BaseScreen {
    public ErrorScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement submitButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement dialogMessage;
    public  String checkErrorMessage(){
            new WebDriverWait(driver,5)
                    .until(ExpectedConditions.visibilityOf(dialogMessage));
            String  message = dialogMessage.getText();
            return message;
        }

    public LoginScreen confirmError() {
        should(submitButton,10);
        submitButton.click();
        return new LoginScreen(driver);
    }
}
