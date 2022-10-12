package ru.mrh1tech.worldscolor.handlers;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.mrh1tech.worldscolor.services.colorchangers.ColorChangerServiceTab;
import ru.mrh1tech.worldscolor.services.colorchangers.ColorChangerServiceTeams;

public class JoinHandler implements Listener {

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent event) {
        changeColor(event.getPlayer());
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        changeColor(event.getPlayer());
    }

    private void changeColor(Player player) {
        ColorChangerServiceTeams.changeColor(player);
        ColorChangerServiceTab.changeColor(player);
    }

}


