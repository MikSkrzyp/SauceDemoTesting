package configuration;

public class AppProperties {

//Class includes method getAllUrl which uses ConfigurationProperties to retrieve app.url property from configuration.properties file


    public static String getAllUrl() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }

}