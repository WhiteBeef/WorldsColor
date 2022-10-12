package ru.mrh1tech.worldscolor.placeholderapi;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.mrh1tech.worldscolor.services.colorchoosers.ColorChooserService;


public class WorldsColorExpansion extends PlaceholderExpansion {


    @NotNull
    public String getIdentifier() {
        return "worldscolor";
    }

    @NotNull
    public String getAuthor() {
        return "_WhiteBeef_";
    }

    @NotNull
    public String getVersion() {
        return "1.1.0";
    }


    public boolean canRegister() {
        return true;
    }


    public boolean persist() {
        return true;
    }


    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) return null;

        if (params.equals("colored_nickname")) {
            return ColorChooserService.getColor(player.getWorld().getName()) + player.getName();
        }
        if (params.equals("color")) {
            return ColorChooserService.getColor(player.getWorld().getName()) + "";
        }

        return null;
    }
}