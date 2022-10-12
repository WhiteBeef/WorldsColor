package ru.mrh1tech.worldscolor.services.colorchoosers;


import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import ru.mrh1tech.worldscolor.WorldsColor;

import java.util.HashMap;

public class ColorChooserService {

    private static final HashMap<String, String> worldsColors = new HashMap<>();


    public static ChatColor getColor(String worldName) {
        return ChatColor.valueOf(worldsColors.get(worldName));
    }

    public static void initializeColors() {
        FileConfiguration config = WorldsColor.getInstance().getConfig();

        for (String name : config.getConfigurationSection("colors").getKeys(false)) {
            String color = config.getString("colors." + name);
            worldsColors.put(name, color);
        }
    }
}

