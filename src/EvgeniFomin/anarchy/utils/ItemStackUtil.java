package EvgeniFomin.anarchy.utils;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemStackUtil implements Listener {

    private static String[] EMPTY_STRING_ARRAY = new String[0];

    public static ItemStack createItemStack(Material m, int amount, byte data, String displayName, String... lore) {
        ItemStack returnment = new ItemStack(m, amount, data);
        ItemMeta meta = returnment.getItemMeta();
        if (displayName != null)
            meta.setDisplayName(displayName.replace('&', '§'));
        if (lore != null && lore.length > 0)
            meta.setLore(Arrays.asList(lore));
        returnment.setItemMeta(meta);
        return returnment;
    }

    public static ItemStack createItemStack(Material m, int amount, byte data, String displayName) {
        return createItemStack(m, amount, data, displayName, EMPTY_STRING_ARRAY);
    }
}