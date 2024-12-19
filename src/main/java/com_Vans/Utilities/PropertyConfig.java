package com_Vans.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {
	
	private Properties property;
	
	public PropertyConfig() {
		property = new Properties();
		String filepath = "./src/main/java/com_Vans/Utilities/configuration.properties";
//		System.out.println(filepath);
//		System.out.println("Working Directory = " + System.getProperty("user.dir"));
		try (FileInputStream fileInputStream = new FileInputStream(filepath)) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file: " + filepath);
        }
	}
	public String getProperty(String key) {
        return property.getProperty(key);
    }
	public static void main(String[] args) {
		PropertyConfig config = new PropertyConfig();
		String test = config.getProperty("Driver_Path");
		System.out.println("your result : "+ test);
	}
}
