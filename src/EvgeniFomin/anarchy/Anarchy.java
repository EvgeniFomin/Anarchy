package EvgeniFomin.anarchy;

import EvgeniFomin.anarchy.command.Command;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import EvgeniFomin.anarchy.events.EventListener;
import EvgeniFomin.anarchy.manager.Region;
import EvgeniFomin.anarchy.manager.RegionManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import static EvgeniFomin.anarchy.manager.RegionManager.cache;

public class Anarchy extends JavaPlugin {

    private static Anarchy instance;
    HashMap<Player, ArrayList<Region>> regions = new HashMap<Player, ArrayList<Region>>();
    HashMap<String,Set<String>> idsPlayersRegions = new HashMap<>();
    private RegionManager regionManager;
    public  HashMap<Player,Region> rgs = new HashMap<>();

    public static int[] slots = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34};
    public static HashMap<Player, Integer> pages  = new HashMap();

    public static Anarchy getInstance() {
        if (instance == null) {
            instance = new Anarchy();
            return instance;
        }
        return instance;
    }

    public HashMap<String, Set<String>> getIdsPlayersRegions() {
        return idsPlayersRegions;
    }

    public RegionManager getRegionManager() {
        return regionManager;
    }

    public void onEnable() {
        getServer().getConsoleSender().sendMessage(Messages.prefix + "§aStart plugin§7.");
        instance = this;
        ConfigManager.init();
        regionManager = new RegionManager(this);
        this.getCommand("rg").setExecutor(new Command(this));
        EventListener.getListener().EventListener(this);

        ArrayList<Region> a = new ArrayList<Region>();
        Set<String> playersregionsinfo = ConfigManager.data().c().getConfigurationSection("regions").getKeys(false);
        for (String playerRegion : playersregionsinfo) {
            Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + playerRegion).getKeys(false);
            for (String idd : id) {
                if (!a.contains(new Region(playerRegion, new Integer(idd), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".x"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".y"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".z"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".level"), (ArrayList<String>) ConfigManager.data().c().getList("regions." + playerRegion + "." + idd + ".members")))) {
                    a.add((new Region(playerRegion, new Integer(idd), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".x"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".y"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".z"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".level"), (ArrayList<String>) ConfigManager.data().c().getList("regions." + playerRegion + "." + idd + ".members"))));
                    cache.put(playerRegion, a);
                    // player,  id,  x,  y,  z,  level, members
                    idsPlayersRegions.put(playerRegion,id);
                }
            }
        }
//      for (Region rg : getRegions()){
//          Bukkit.getConsoleSender().sendMessage("Владелец: " + rg.getOwner());
//          Bukkit.getConsoleSender().sendMessage("Уровень: " + rg.getLevel());
//          Bukkit.getConsoleSender().sendMessage("ID: " + rg.getId());
//          Bukkit.getConsoleSender().sendMessage("Участники: " + rg.getMembers());
//          Bukkit.getConsoleSender().sendMessage("X: " + rg.getX());
//          Bukkit.getConsoleSender().sendMessage("Y: " + rg.getY());
//          Bukkit.getConsoleSender().sendMessage("Z: " + rg.getZ());
//        }
    }


    public static List<Region> getRegions() {
        ArrayList<Region> rgs = new ArrayList<>();
        for (ArrayList<Region> a : cache.asMap().values()) {
            rgs.addAll(a);
        }
        return rgs;
    }
}
