package core.config;

import java.io.InputStream;
import java.util.Objects;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPS = new Properties();
    private static boolean initialized = false;

    private ConfigReader() {}

    public static synchronized void init() {

        if (initialized) return;

        load("config/common.properties");

        String site = System.getProperty("site", "saucedemo").toLowerCase();
        load("config/" + site + ".properties");

        System.getProperties().forEach((k, v) ->
                PROPS.setProperty(String.valueOf(k), String.valueOf(v)));

        initialized = true;
    }

    private static void load(String path) {

        try (InputStream is =
                     ConfigReader.class.getClassLoader().getResourceAsStream(path)) {

            Objects.requireNonNull(is, "Config not found: " + path);
            PROPS.load(is);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config: " + path, e);
        }
    }

    public static String get(String key) {
        init();
        return PROPS.getProperty(key);
    }

    public static String getOrDefault(String key, String def) {
        init();
        return PROPS.getProperty(key, def);
    }

    public static boolean getBool(String key) {
        return Boolean.parseBoolean(getOrDefault(key, "false"));
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}