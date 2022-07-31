package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;




public class configManager {
    public static ThreadLocal<Properties> commonProp = new ThreadLocal<Properties>();
    public static ThreadLocal<Boolean> arePropertiesSet = new ThreadLocal<Boolean>();
    public static ThreadLocal<Boolean> arePropertiesUpdated = new ThreadLocal<Boolean>();
    static FileReader reader;

    static {
        arePropertiesSet.set(false);
    }

    public static void setProperties() {
        try {
            try {

                if (arePropertiesSet.get()) {
                    return;
                }
            } catch (Exception e) {
                System.out.println("Seems AreProperties was not set.");
                arePropertiesSet.set(false);
            }

            commonProp.set(new Properties());
            reader = new FileReader("src/main/resources/config.properties");
            commonProp.get().load(reader);
            commonProp.get().setProperty("testvar", "test");
            arePropertiesSet.set(true);
            arePropertiesUpdated.set(false);
        } catch (IOException e) {
            e.printStackTrace();
            arePropertiesSet.set(false);
            arePropertiesUpdated.set(false);
        }
    }

    public static Properties getProperties() {
        return commonProp.get();
    }


}

