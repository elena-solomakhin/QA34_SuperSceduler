
package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
import org.openqa.selenium.support.FindBy;


public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;
    @FindBy(xpath="//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen  fillEmail(String email){

        should(emailEditText,10);
        type(emailEditText,email);
//      return  new LoginScreen(driver); == this
        return  this;
    }

    public LoginScreen  fillPassword(String password){
        type(passwordEditText,password);
//      return  new LoginScreen(driver); == this
        return  this;
    }
    public HomeScreen submitLogin(){
        driver.hideKeyboard();
      loginButton.click();
      return  new HomeScreen(driver);

    }
    public WizardScreen submitRegistration(){
        driver.hideKeyboard();
        loginButton.click();
        return  new WizardScreen(driver);

    }
    public HomeScreen complexLogin(User user){
        should(emailEditText,10);
        type(emailEditText,user.getEmail());
        type(passwordEditText,user.getPassword());
        submitLogin();
        return  new HomeScreen(driver);


    }
    public ErrorScreen complexWrongLogin(User user){
        should(emailEditText,10);
        type(emailEditText,user.getEmail());
        type(passwordEditText,user.getPassword());
        submitLogin();
        return  new ErrorScreen(driver);


    }
}