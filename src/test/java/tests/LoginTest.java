package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;


public class LoginTest extends Configuration {

    @Test
    public void loginTestSuccess() {
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("sara@gmail.com")
                .fillPassword("Ssara1234$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginSuccessModel() {
User user =User.builder().email("sara@gmail.com").password("Ssara1234$").build();
        logger.info("Test start with user-->"+user.toString());
        boolean addPresent = new LoginScreen(driver)
                .complexLogin(User.builder().email("sara@gmail.com").password("Ssara1234$").build())
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @Test
    public void loginNegativeModelWrongPassword() {
       new LoginScreen(driver)
                .complexLoginNegative(User.builder().email("sara@gmail.com").password("Nnoa1234$").build())
                .checkErrorMessage("Wrong email or password")
                .confirmError();

    }

    @Test
    public void loginTestSuccess2() {
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent = new LoginScreen(driver)
                .fillEmail("sara@gmail.com")
                .fillPassword("Ssara1234$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @AfterMethod
    public void postCondition() {
//        logout
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
