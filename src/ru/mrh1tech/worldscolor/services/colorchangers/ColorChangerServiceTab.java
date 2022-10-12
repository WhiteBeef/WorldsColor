package ru.mrh1tech.worldscolor.services.colorchangers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;
import ru.mrh1tech.worldscolor.WorldsColor;
import ru.mrh1tech.worldscolor.services.colorchoosers.ColorChooserService;

public class ColorChangerServiceTab {

    public static void changeColor(Player player) {

        String worldName = player.getWorld().getName();

        String playerName = player.getName();

        String teamPrefix = "";

        Team team = Bukkit.getScoreboardManager().getMainScoreboard().getEntryTeam(playerName);
        if (team != null) {
            teamPrefix = team.getPrefix();
        } else {
            String teamName = worldName + "_" + playerName;
            team = WorldsColor.getInstance().getScoreboard().getTeam(teamName);
            if (team == null)
                team = WorldsColor.getInstance().getScoreboard().registerNewTeam(teamName);
            team.addEntry(playerName);
        }

        player.setPlayerListName(teamPrefix + ColorChooserService.getColor(worldName) + playerName);
    }

}

