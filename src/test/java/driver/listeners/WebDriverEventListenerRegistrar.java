package driver.listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

public class WebDriverEventListenerRegistrar {

    //here we are registering our DriverEventListener

    public synchronized static WebDriver registerWebDriverEventListener(WebDriver driver) {

        DriverEventListener driverEventListener = new DriverEventListener();

        EventFiringDecorator eventFiringDecorator = new EventFiringDecorator(driverEventListener);

        return eventFiringDecorator.decorate(driver);
    }

}