package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;

import java.util.Collections;

public class RegistrationTest extends Configuration {
    @Test
    public void registrationSuccess(){
       int i=(int)System.currentTimeMillis()/1000%3600;
       new LoginScreen(driver)
                .fillEmail("gera"+i+"@gmail.com")
                .fillPassword("Ggera1234$")
                 .submitRegistration()
                 .skipWizard()
            .checkFabButtonPresent()
        .openMenu()
                .logout();

    }
}
