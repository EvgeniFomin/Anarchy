package EvgeniFomin.anarchy.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler
    public void onPlayerQuitEvent(org.bukkit.event.player.PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage("§7[§c-§7] " + p.getName());
    }
}
