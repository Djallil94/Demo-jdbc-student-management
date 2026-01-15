package com.Djallil.db;

import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static  {
        try (InputStream is = DatabaseConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {
            properties.load(is);
        } catch (Exception e) {
            throw  new RuntimeException("Erreur chargement properties", e);
        }
    }

    public static String getUrl() {
        return properties.getProperty("db.url");
    }

    public static String getUser() {
        return properties.getProperty("db.user");
    }

    public static String getPassword() {
        return properties.getProperty("db.password");
    }
}
