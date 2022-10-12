package ru.mrh1tech.worldscolor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import ru.mrh1tech.worldscolor.commands.WorldsColorCommand;
import ru.mrh1tech.worldscolor.handlers.JoinHandler;
import ru.mrh1tech.worldscolor.placeholderapi.WorldsColorExpansion;
import ru.mrh1tech.worldscolor.services.colorchangers.ColorChangerServiceTab;
import ru.mrh1tech.worldscolor.services.colorchangers.ColorChangerServiceTeams;
import ru.mrh1tech.worldscolor.services.colorchoosers.ColorChooserService;

public final class WorldsColor extends JavaPlugin {
    private static WorldsColor instance;
    private Scoreboard scoreboard;

    public static WorldsColor getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

        initializeConfig();

        registerEvents();
        registerCommands();
        initTeams();

        hookPapi();
    }


    private void initializeConfig() {
        saveDefaultConfig();
        reloadConfig();

        ColorChooserService.initializeColors();
    }

    private void initTeams() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            ColorChangerServiceTab.changeColor(player);
            ColorChangerServiceTeams.changeColor(player);
        }
    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new JoinHandler(), this);
    }

    private void registerCommands() {
        getCommand("worldscolor").setExecutor(new WorldsColorCommand());
    }

    private void hookPapi() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
            (new WorldsColorExpansion()).register();
        } else {
            getLogger().info("PlaceholderAPI didn't hook!");
        }
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }


}