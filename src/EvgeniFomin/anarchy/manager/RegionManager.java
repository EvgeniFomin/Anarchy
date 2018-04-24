/*
 * Decompiled with CFR 0_123.
 *
 * Could not load the following classes:
 *  com.google.common.cache.CacheBuilder
 *  com.google.common.cache.CacheLoader
 *  com.google.common.cache.LoadingCache
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  ru.luvas.multiutils.sql.Connector
 */
package EvgeniFomin.anarchy.manager;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RegionManager {
    public static LoadingCache<String, ArrayList<Region>> cache;
    private Anarchy plugin;

    public RegionManager(Anarchy plugin) {
        this.cache = CacheBuilder.newBuilder().softValues().build(new CacheLoader<String, ArrayList<Region>>() {
            public ArrayList<Region> load(String player) {
                ArrayList<Region> a = new ArrayList<>();
                Set<String> players = ConfigManager.data().c().getConfigurationSection("regions").getKeys(false);
                for (String playerRegion : players) {
                    Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + playerRegion).getKeys(false);
                    for (String idd : id) {
                        if (!a.contains(new Region(playerRegion, new Integer(idd), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".x"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".y"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".z"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".level"), (ArrayList<String>) ConfigManager.data().c().getList("regions." + playerRegion + "." + idd + ".members")))) {
                            a.add(new Region(playerRegion, new Integer(idd), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".x"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".y"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".z"), ConfigManager.data().c().getInt("regions." + playerRegion + "." + idd + ".level"), (ArrayList<String>) ConfigManager.data().c().getList("regions." + playerRegion + "." + idd + ".members")));
                            // player,  id,  x,  y,  z,  level, members
                        }
                    }
                }
                return a;
            }
        });
        this.plugin = plugin;
    }

    public void save(String player) {
        try {
            ArrayList<Region> toSave = this.cache.get(player);
            Thread s = new Thread(() -> {
                for (int i = 0; i < toSave.size(); i++) {
//                    ConfigManager.data().c().set("regions." + player + "." + toSave.get(i).getId() + ".owner", toSave.get(i).getOwner());
//                    ConfigManager.data().save();
//                    System.out.println("Сохраняю владельца региона");
                    ConfigManager.data().c().set("regions." + toSave.get(i).getOwner() + "." + toSave.get(i).getId() + ".x", toSave.get(i).getX());
                    ConfigManager.data().save();
//                    System.out.println("Сохраняю координату х");
                    ConfigManager.data().c().set("regions." + toSave.get(i).getOwner() + "." + toSave.get(i).getId() + ".y", toSave.get(i).getY());
                    ConfigManager.data().save();
//                    System.out.println("Сохраняю координату у");
                    ConfigManager.data().c().set("regions." + toSave.get(i).getOwner() + "." + toSave.get(i).getId() + ".z", toSave.get(i).getZ());
                    ConfigManager.data().save();
//                    System.out.println("Сохраняю координату z");
                    ConfigManager.data().c().set("regions." + toSave.get(i).getOwner() + "." + toSave.get(i).getId() + ".level", toSave.get(i).getLevel());
                    ConfigManager.data().save();
//                    System.out.println("Сохраняю уровень");
                    ConfigManager.data().c().set("regions." + toSave.get(i).getOwner() + "." + toSave.get(i).getId() + ".members", toSave.get(i).getMembers());
                    ConfigManager.data().save();
//                    System.out.println("Сохраняю участников");
                    System.out.println("Количество регионов игрока  " + toSave.get(i).getOwner() + ": " + toSave.size());
                }
            });
            s.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Region> getRegion(String player) {
        try {
            return this.cache.get(player);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

