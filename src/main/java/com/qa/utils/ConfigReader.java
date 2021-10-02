package com.qa.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties prop;

    /**
     * Initialize and load the properties file
     * @return properties object
     */
    public Properties initProp(){

        prop= new Properties();
        try {
            FileInputStream propertiesFile = new FileInputStream("src/test/resources/config/config.properties");
            prop.load(propertiesFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
