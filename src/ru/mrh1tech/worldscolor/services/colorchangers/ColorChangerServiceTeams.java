package ru.mrh1tech.worldscolor.services.colorchangers;


import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import ru.mrh1tech.worldscolor.WorldsColor;
import ru.mrh1tech.worldscolor.services.colorchoosers.ColorChooserService;

public class ColorChangerServiceTeams {

    public static void changeColor(Player player) {
        String worldName = player.getWorld().getName();

        String playerName = player.getName();
        Scoreboard scoreboard = WorldsColor.getInstance().getScoreboard();

        Team team = scoreboard.getEntryTeam(playerName);
        if (team != null) {
            team.setColor(ColorChooserService.getColor(worldName));
            team.setCanSeeFriendlyInvisibles(false);
        }
    }
}

