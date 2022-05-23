package ch.bzz.flugverwaltung.service;

import ch.bzz.flugverwaltung.model.Passagier;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

/**
 * configure the web services and properties
 *
 * @author Gabriel Martinez
 */

@ApplicationPath("/resource")

public class Config extends Application {
    private static final String PROPERTIES_PATH = "/home/bzz/webapp/flugList.properties";
    private static Properties properties = null;

    /**
     * definiert alle Provider Klassen
     *
     * @return set von Klassen
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet providers = new HashSet<Class<?>>();
        providers.add(PassagierService.class);
        providers.add(TestService.class);
        providers.add(FlugService.class);
        providers.add(FlugzeugService.class);
        return providers;
    }

    /**
     * Bekommt den Wert einer Property
     *
     * @param property das Schlüssel der Property
     */
    public static String getProperty(String property) {
        if (Config.properties == null) {
            setProperties(new Properties());
            readProperties();
        }
        String value = Config.properties.getProperty(property);
        if (value == null) return "";
        return value;
    }

    /**
     * Liest die Properties Files
     */
    private static void readProperties() {

        InputStream inputStream;
        try {
            inputStream = new FileInputStream(PROPERTIES_PATH);
            properties.load(inputStream);
            if (inputStream != null) inputStream.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Setzt die Properties
     *
     * @param properties the value to set
     */
    private static void setProperties(Properties properties) {
        Config.properties = properties;
    }

    }


