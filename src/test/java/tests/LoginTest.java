package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ErrorScreen;
import screens.HomeScreen;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTest extends Configuration {
    @Test
    public void loginTestSuccess(){
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent =  new LoginScreen(driver)
                .fillEmail("sara@gmail.com")
                .fillPassword("Ssara1234$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void loginSuccessModel(){
        boolean addPresent= new LoginScreen(driver)
                .complexLogin(User.builder().email("sara@gmail.com").password("Ssara1234$").build())
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void loginNegativeModelWrongPassword(){
        String negativeError= new LoginScreen(driver)
                .complexWrongLogin(User.builder().email("sara@gmail.com").password("Nnoa1234$").build())
         .checkErrorMessage();
        Assert.assertEquals(negativeError,"Wrong email or password");
         new ErrorScreen(driver)
                .confirmError();

    }

    @Test
    public void loginTestSuccess2(){
//        boolean addPresent = new SplashScreen(driver)
//                .checkCurrentVersion("0.0.3")
        boolean addPresent =  new LoginScreen(driver)
                .fillEmail("sara@gmail.com")
                .fillPassword("Ssara1234$")
                .submitLogin()
                .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @AfterMethod
    public void postCondition(){
//        logout
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
