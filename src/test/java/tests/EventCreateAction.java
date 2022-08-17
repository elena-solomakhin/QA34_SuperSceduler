package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class EventCreateAction
        extends Configuration {


    @Test
    public void createNewEvent(){
        new LoginScreen(driver)
                .complexLogin(User.builder()
                        .email("sara@gmail.com")
                        .password("Ssara1234$")
                        .build())
                .initCreationEvent()
                .dataAction()
                .createNewEvent(Event.builder()
                .title("Meeting")
                .type("Doctor")
                .breakes(2)
                .wage(50)
                .build())
                .checkFabButtonPresent()
                .openMenu()
                .logout();


    }
    @Test
    public void createNewEventCheckDAta(){
        new LoginScreen(driver)
                .complexLogin(User.builder()
                        .email("sara@gmail.com")
                        .password("Ssara1234$")
                        .build())
                .initCreationEvent()
                .selectDataAction("18/08/2022")
                .createNewEvent(Event.builder()
                        .title("Meeting")
                        .type("Doctor")
                        .breakes(2)
                        .wage(50)
                        .build())
                .checkFabButtonPresent()
                .openMenu()
                .logout();


    }
}
