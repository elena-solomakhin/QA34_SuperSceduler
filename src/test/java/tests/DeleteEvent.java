package tests;
//findBy can

import io.appium.java_client.MobileElement;
import manager.Configuration;
import models.User;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.EditCreateEventScreen;
import screens.HomeScreen;
import screens.LoginScreen;

public class DeleteEvent extends Configuration {

    @Test
    public void deleteElement() {
        new LoginScreen(driver)
                .complexLogin(User.builder()
                        .email("sara@gmail.com")
                        .password("Ssara1234$").build())
                        .findEvent()
                        .deletePastEvent()
        .checkFabButtonPresent()
                .openMenu()
                .logout();

    }
}
