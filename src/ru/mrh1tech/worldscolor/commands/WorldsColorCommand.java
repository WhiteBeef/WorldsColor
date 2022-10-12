package ru.mrh1tech.worldscolor.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.*;
import ru.mrh1tech.worldscolor.WorldsColor;

import java.util.Collections;
import java.util.List;


public class WorldsColorCommand implements TabExecutor {
    private final String LOGO;

    public WorldsColorCommand() {
        this.LOGO = "§8[§9Worlds§bColor§8] ";
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        WorldsColor plugin = WorldsColor.getInstance();
        if (args.length < 1) {
            sender.sendMessage(LOGO +
                    ChatColor.translateAlternateColorCodes('&', plugin
                            .getConfig().getString("messages.errors.no-arguments")));
            return true;
        }


        if (args[0].equals("reload")) {
            plugin.reloadConfig();
            sender.sendMessage(LOGO +
                    ChatColor.translateAlternateColorCodes('&', plugin
                            .getConfig().getString("messages.config-reload-successfully")));
            return true;
        }
        sender.sendMessage(LOGO +
                ChatColor.translateAlternateColorCodes('&', plugin
                        .getConfig().getString("messages.errors.no-arguments")));
        return true;
    }


    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length == 1) {
            return List.of("reload");
        }
        return Collections.emptyList();
    }
}


