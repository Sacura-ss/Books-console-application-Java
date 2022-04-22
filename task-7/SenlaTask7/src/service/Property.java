package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property {
    public static final String PATH_TO_PROPERTIES = "config/application.properties";

    public static String getPropertyValue(String propertyName) {
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();
        String propertyValue = "";
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return propertyValue;
    }
}
