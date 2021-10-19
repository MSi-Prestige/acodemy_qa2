package utils;

import exceptions.PropertyReadingException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

    public static Properties properties;

    public static Properties readProperties() {
        FileReader reader;

        try {
            reader = new FileReader("configuration.properties");
        } catch (FileNotFoundException e) {
            throw new PropertyReadingException(e);
        }

        Properties props = new Properties();

        try {
            props.load(reader);
        } catch (IOException e) {
            throw new PropertyReadingException(e);
        }
        return props;
    }

    public static Properties getProperties() {
        if (properties == null) {
            properties = readProperties();
        }
        return properties;
    }
}
