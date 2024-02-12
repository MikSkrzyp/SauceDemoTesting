package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    // Abstract class which make page.objects classes less crowded

    //instance of logger to make custom logs
    private Logger logger = LogManager.getLogger(this.getClass().getName());


    //constructor with PageFactory which is needed to make POP work
    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    //method which returns logger
    protected Logger log() {
        return logger;
    }

}