package EvgeniFomin.anarchy.configManager;

import java.util.ArrayList;

public class ConfigManager {
    private static Config config;
    private static Config data;

    public static void init() {
        ConfigManager.config = new Config("config.yml", "config.yml");
        ConfigManager.data = new Config("data.yml", "data.yml");
        ConfigManager.data.initialize();
        ConfigManager.config.initialize();
    }

    public static Config config() {
        return ConfigManager.config;
    }

    public static Config data() {
        return data;
    }

    public static String cv(String path) {
        return ConfigManager.config.c().getString(path);
    }

    public static String txt(String path) {
        return ConfigManager.config.c().getString(path);
    }

    public static String txt2(String path) {
        String str = "";
        for (final String line : ConfigManager.config.c().getStringList(path)) {
            str = str + line + "\n";
        }
        return str;
    }

    public static ArrayList<String> txt3(String path) {
        ArrayList<String> lines = new ArrayList<String>();
        for (String line : ConfigManager.config.c().getStringList(path)) {
            lines.add(line);
        }
        return lines;
    }
}