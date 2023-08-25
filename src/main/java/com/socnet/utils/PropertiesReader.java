package com.socnet.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;

    private String dbURL;
    private String dbName;
    private String dbPass;

    public String getDbURL() {
        return dbURL;
    }

    public String getDbName() {
        return dbName;
    }

    public String getDbPass() {
        return dbPass;
    }

    private PropertiesReader(){

    }

    public static PropertiesReader getInstance(){
        if(instance == null){
            instance = new PropertiesReader();
        }
        return instance;
    }

    public void loadProps(){
        try (InputStream input = new FileInputStream("D:\\DB_training\\JavaTraining23\\app.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            this.dbName=prop.getProperty("dbName");
            this.dbURL=prop.getProperty("URL");
            this.dbPass=prop.getProperty("dbPass");
            // get the property value and print it out


        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
