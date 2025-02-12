package org.bharath.utils;


import org.bharath.constants.FrameworkConstants;
import org.bharath.enums.ConfigProperties;
import org.bharath.exceptions.FrameworkException;
import org.bharath.exceptions.InvalidPropertyFileKeyException;
import org.bharath.exceptions.InvalidPropertyFilePathException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyFileReader {

    private PropertyFileReader() {
    }

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getConfigFilePath());) {
            property.load(fileInputStream);
            for (Map.Entry<Object, Object> entry : property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }
            //Using Lambda
            //property.entrySet().forEach(entry -> CONFIGMAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));

        } catch (IOException e) {
            System.exit(0);
        }
    }

    public static String get(ConfigProperties key) {
        System.out.println("ConfigProperties: " + key.name().toLowerCase());
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new InvalidPropertyFileKeyException("Property key " + key + " is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}

//Use the below HashTable implementation if retrieval is only few times as Hashtable is slow but Threadsafe
//For many number of property value retrievals , you can convert to Hashmap and use

/*public static String getProp(String key) throws Exception {
    if (Objects.isNull(key) || Objects.isNull(property.getProperty(key))) {
        throw new Exception("Property key " + key + " is not found. Please check config.properties");
    }
    return property.getProperty(key);

}*/

