package EvgeniFomin.anarchy.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class CustomItem {

    public static ItemStack createCustomItem(Material m, int amount, byte data, String displayName, ArrayList addLore) {
        ItemStack stack = new ItemStack(m, amount, data);
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(addLore);
        meta.setDisplayName(displayName);
        stack.setItemMeta(meta);
        return stack;
    }

    public static ItemStack createCustomItem(Material m, int amount, byte data, String displayName) {
        ItemStack stack = new ItemStack(m, amount, data);
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(displayName);
        stack.setItemMeta(meta);
        return stack;
    }
}
