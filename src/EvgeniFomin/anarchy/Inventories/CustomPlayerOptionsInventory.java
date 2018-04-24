package EvgeniFomin.anarchy.Inventories;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.List;

public class CustomPlayerOptionsInventory {
    private Anarchy plugin;

    public CustomPlayerOptionsInventory(Anarchy plugin) {
        this.plugin = plugin;
    }

//10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30, 31, 32, 33, 34

    public static void CustomPlayerOptions(Player p, String key) {
        Inventory inv = Bukkit.createInventory(null, 45, "Управление регионом.");
        ConfigurationSection section = ConfigManager.data().c().getConfigurationSection("Region");
        if (section.getString(key + ".Owner").equals(p.getName())) {
            int level = section.getInt(key + ".Level");
            List<?> members = section.getList(key + ".Members");

//            if () {
//                inv.setItem(10, createItemStack(Material.SKULL_ITEM, 1, (byte) 3, "" + members.get(0)));
//            }
//            inv.setItem(11,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(12,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(13,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(14,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(15,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(16,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//
//            inv.setItem(19,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(20,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(21,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(22,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(23,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(24,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(25,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//
//            inv.setItem(28,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(29,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(30,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(31,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(32,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(33,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
//            inv.setItem(34,createItemStack(Material.SKULL_ITEM,1,(byte) 3,"" + members.get(0)));
            p.openInventory(inv);
        }
    }
}
