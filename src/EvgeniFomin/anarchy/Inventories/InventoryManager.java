package EvgeniFomin.anarchy.Inventories;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static EvgeniFomin.anarchy.utils.ItemStackUtil.createItemStack;

public class InventoryManager {

    public static void Menu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "Управление регионом");
        ItemStack item1 = createItemStack(Material.SKULL_ITEM, 1, (byte) 3, "§aУчастники [{members}]".replace("{members}", ""));
        ItemStack item2 = createItemStack(Material.REDSTONE, 1, (byte) 0, "§6Расширить регион");
        ItemStack item3 = createItemStack(Material.BARRIER, 1, (byte) 0, "§cЗакрыть");
        inv.setItem(11, item1);
        inv.setItem(13, item2);
        inv.setItem(15, item3);
        p.openInventory(inv);
    }
}
