package EvgeniFomin.anarchy.events;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.Messages;
import EvgeniFomin.anarchy.manager.Region;
import EvgeniFomin.anarchy.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class PlayerJoinEvent implements Listener {


    @EventHandler
    public void onPlayerJoinEvent(org.bukkit.event.player.PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage("§7[§a+§7] " + e.getPlayer().getName());
    }
}
