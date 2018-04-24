package EvgeniFomin.anarchy.events;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.manager.RegionInv;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EventListener {
    private static EventListener instance;

    public static EventListener getListener() {
        if (instance == null) {
            instance = new EventListener();
        }
        return instance;
    }

    public void EventListener(JavaPlugin plugin) {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerListener(Anarchy.getInstance()), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new RegionInv(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerQuitEvent(), plugin);
    }
}
