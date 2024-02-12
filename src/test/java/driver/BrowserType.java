package driver;

public enum BrowserType {

    //Enum with names of browsers implemented in this project
    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browser;
    BrowserType(String browser) {
        this.browser = browser;
    }
}
