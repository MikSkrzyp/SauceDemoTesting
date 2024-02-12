package configuration;

import driver.BrowserType;

public class TestRunProperties {

    //Class has 3 methods which returns from configuration.properties information:
    // about GridUrl, if we want to run tests remotely and which browser we want to use


    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }

    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));
    }

    public static boolean getIsRemoteRun(){
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }
}