package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Property {
    public static final String PATH_TO_PROPERTIES = "config/application.properties";
    private Map<String, String> mapProperties = new HashMap<String, String>();

    public Property() {
        FileInputStream fileInputStream = null;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            for (String key : properties.stringPropertyNames()) {
                mapProperties.put(key, properties.getProperty(key));
            }
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
    }

    public String getPropertyValue(String propertyName) {
        return mapProperties.get(propertyName);
    }
}
