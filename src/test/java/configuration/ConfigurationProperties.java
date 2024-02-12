package configuration;

import java.util.Properties;

public class ConfigurationProperties {

//Class stores all loaded properties and it uses Singleton(i described it shortly in DriverManager class)

    private static Properties properties;


    private ConfigurationProperties() {
    }

    //loading properties object to static object of type Properties
    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    //returns all loaded properties
    public static Properties getProperties() {
        if (properties == null) {
            throw new IllegalStateException("Please set properties using setProperties() before calling getProperties()");
        }
        return properties;
    }

}