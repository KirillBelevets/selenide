package сontentGuru.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesCacheGuru {
        private final Properties configProp = new Properties();
        private static final PropertiesCacheGuru INSTANCE = new PropertiesCacheGuru();

        private PropertiesCacheGuru() {
            InputStream in = this.getClass().getClassLoader().getResourceAsStream("testguru.properties");
            try {
                configProp.load(in);
            } catch (IOException e) {
                System.out.println(e.toString());
            }
        }

        public static String getProperty(String key) {
            return INSTANCE.configProp.getProperty(key);
        }

    }

