package tests;

import manager.Configuration;
import models.Event;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class EventCreateTests2  extends Configuration {


    @Test
    public void createNewEventSuccsess2(){
     new LoginScreen(driver)
            .complexLogin(User.builder()
                    .email("sara@gmail.com")
                    .password("Ssara1234$")
                    .build());

        Event event = Event.builder()
                .title("Meeting")
                .type("Doctor")
                .breakes(2)
                .wage(50)
                .build();
        boolean isfabPresent=new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(event)
                .isFabAddPresent();
        Assert.assertTrue(isfabPresent);


    }
}
