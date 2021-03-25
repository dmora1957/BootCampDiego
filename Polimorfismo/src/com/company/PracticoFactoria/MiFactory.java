package com.company.PracticoFactoria;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class MiFactory {
    public static Object getInstance(String objName)
    {
        try (InputStream input = new FileInputStream("MIFactory.properties")) {
            Properties prop = new Properties();
            prop.load(input);

            var currentProperty = prop.getProperty(objName);
            var obj = Class.forName(currentProperty);
            return obj;
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
