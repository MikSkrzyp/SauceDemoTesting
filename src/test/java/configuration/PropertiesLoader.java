package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    //Class includes method which reads properties from given properties file

    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    public Properties getPropertiesFromFile(String propertiesFileName) {

        //inputstream helps us to read properties
        InputStream inputStream = null;

        Properties properties = new Properties();
        try {
            logger.info("Trying to load properties with file name: " + propertiesFileName);

            //here we are reading properties
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if (inputStream != null) {
                //loading properties to Properties object
                properties.load(inputStream);
                logger.info("Successfully loaded properties for file: " + propertiesFileName);
            } else {
                throw new FileNotFoundException("Property file '" + propertiesFileName + "' not found in the classpath");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            //we are closing inputStream
            closeResource(inputStream);
        }

        return properties;
    }

    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}