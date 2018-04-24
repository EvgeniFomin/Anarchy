package EvgeniFomin.anarchy.events;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.Messages;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import EvgeniFomin.anarchy.manager.Region;
import EvgeniFomin.anarchy.manager.RegionInv;
import EvgeniFomin.anarchy.manager.RegionManager;
import EvgeniFomin.anarchy.utils.Cuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static EvgeniFomin.anarchy.manager.RegionManager.cache;

public class PlayerListener implements Listener {
    Anarchy plugin;
    HashMap<Player, Region> entered = new HashMap<>();

    PlayerListener(Anarchy plugin) {
        this.plugin = plugin;
    }

    public List<Region> getRegions() {
        ArrayList<Region> rgs = new ArrayList<>();
        for (ArrayList<Region> a : cache.asMap().values()) {
            rgs.addAll(a);
        }
        return rgs;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        Location loc = p.getLocation();
        Region rg = null;
        if (getRegions() != null) {
            for (Region rgs : getRegions()) {
                int sizeRegion = range(rgs.getLevel());
                Cuboid cub = new Cuboid(Bukkit.getWorld("world"), rgs.getX(), rgs.getY(), rgs.getZ(), rgs.getX(), rgs.getY(), rgs.getZ()).contract().outset(Cuboid.CuboidDirection.Both, sizeRegion);
                if (cub.contains(loc)) {
                    rg = rgs;
                }
                if ((entered.containsKey(p)) && ((this.entered.get(p)).equals(rgs)) && (!cub.contains(loc))) {
                    this.entered.remove(p);
                    p.sendMessage(Messages.prefix + "§cВы покинули территорию " + rgs.getOwner());
                }
            }
            if (rg == null) {
                return;
            }
            if ((this.entered.containsKey(p)) && ((this.entered.get(p)).equals(rg))) {
                return;
            }
            p.sendMessage(Messages.prefix + "§aВы вошли на территорию " + rg.getOwner());
            this.entered.put(p, rg);
        }
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.DIAMOND_BLOCK) {
            for (Region rg : getRegions()) {
                int sizeRegion = range(rg.getLevel());
                if (new Location(Bukkit.getWorld("world"), rg.getX(), rg.getY(), rg.getZ()).equals(e.getBlock().getLocation())) {
                    if (rg.getOwner().equals(p.getName())) {
                        if (rg != null) {
                            if (rg.getId() == rg.getId()) {
                                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + (rg.getId()), null);
                                ConfigManager.data().save();
                                Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + rg.getOwner()).getKeys(false);
                                Anarchy.getInstance().getIdsPlayersRegions().put(p.getName(), id);
                                cache.asMap().get(p.getName()).remove(rg);
                                p.sendMessage(Messages.prefix + "Вы удалили свой регион.");
                                return;
                            }
                        }
                    } else {
                        p.sendMessage(Messages.prefix + "§cТолько глава может удалить регион.");
                        e.setCancelled(true);
                        break;
                    }
                }
            }
            e.setCancelled(true);
        } else {
            for (Region rg : getRegions()) {
                if (!rg.getMembers().contains(p.getName())) {
                    int sizeRegion = range(rg.getLevel());
                    Cuboid cub = new Cuboid(Bukkit.getWorld("world"), rg.getX() + sizeRegion, rg.getY() + sizeRegion, rg.getZ() + sizeRegion, rg.getX() - sizeRegion, rg.getY() - sizeRegion, rg.getZ() - sizeRegion).contract();
                    if ((!rg.getOwner().equals(p.getName())) && (cub.contains(e.getBlock()))) {
                        if (!rg.getMembers().contains(p.getName())) {
                            e.setCancelled(true);
                            p.sendMessage(Messages.prefix + "§cВы не можете ломать здесь блоки. " + rg.getOwner() + "(" + rg.getId() + ")");
                            break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.DIAMOND_BLOCK) {
            Boolean можно = false;
            for (Region rg : getRegions()) {
                Cuboid cub = new Cuboid(Bukkit.getWorld("world"), rg.getX(), rg.getY(), rg.getZ(), rg.getX(), rg.getY(), rg.getZ()).contract();
                if (!p.getName().equals(rg.getOwner())) {
                    if ((int) cub.getCenter().getBlock().getLocation().distance(e.getBlock().getLocation()) < 48) {
                        e.setCancelled(true);
                        p.sendMessage(Messages.prefix + "Не подалеку найден был регион. " + rg.getOwner() + "(" + rg.getId() + ")");
                        p.sendMessage(Messages.prefix + "В дальности §b" + (int) cub.getCenter().getBlock().getLocation().distance(e.getBlock().getLocation()));
                        return;
                    } else {
                        можно = true;
                    }
                }
            }
            if (можно) {
                ArrayList<Integer> ids = new ArrayList<>();
                if (cache.asMap().get(p.getName()) != null) {
                    for (Region id : cache.asMap().get(p.getName())) {
                        ids.add(id.getId());
                    }
                }

                int ig = 0;

                if (ConfigManager.data().c().getConfigurationSection("regions." + p.getName()) != null) {
                    ig = ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false).size();
                }
                if (ig == 0) {
                    System.out.println("1 путь");
                    RegionManager data = Anarchy.getInstance().getRegionManager();
                    int idnewregion = 1;
                    ids.add(idnewregion);
                    data.getRegion(p.getName()).add(new Region(p.getName(), idnewregion, e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ(), 1, new ArrayList<String>()));
                    ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".x", e.getBlock().getX());
                    ConfigManager.data().save();
                    ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".y", e.getBlock().getY());
                    ConfigManager.data().save();
                    ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".z", e.getBlock().getZ());
                    ConfigManager.data().save();
                    ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".level", 1);
                    ConfigManager.data().save();
                    ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".members", new ArrayList<String>());
                    ConfigManager.data().save();
                    System.out.println("Количество регионов игрока  " + p.getName() + ": " + ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false).size());

                    Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false);
                    Anarchy.getInstance().getIdsPlayersRegions().put(p.getName(), id);
                    p.sendMessage(Messages.prefix + "§aРегион успешно создан. (" + id + ")");
                } else {
                    System.out.println("2 путь");
                    if (p.hasPermission("rg.1")) {
                        RegionManager data = Anarchy.getInstance().getRegionManager();
                        int idnewregion = 1;
                        Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false);
                        int i = 1;
                        for (int b = 0; id.contains(String.valueOf(i)); ) {
                            i++;
                            idnewregion = i;
                        }
                        data.getRegion(p.getName()).add(new Region(p.getName(), idnewregion, e.getBlock().getX(), e.getBlock().getY(), e.getBlock().getZ(), 1, new ArrayList<String>()));
                        ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".x", e.getBlock().getX());
                        ConfigManager.data().save();
                        ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".y", e.getBlock().getY());
                        ConfigManager.data().save();
                        ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".z", e.getBlock().getZ());
                        ConfigManager.data().save();
                        ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".level", 1);
                        ConfigManager.data().save();
                        ConfigManager.data().c().set("regions." + p.getName() + "." + idnewregion + ".members", new ArrayList<String>());
                        ConfigManager.data().save();
                        System.out.println("Количество регионов игрока  " + p.getName() + ": " + ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false).size());
                        Set<String> id3 = ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false);
                        Anarchy.getInstance().getIdsPlayersRegions().put(p.getName(), id3);
                        p.sendMessage(Messages.prefix + "§aРегион успешно создан. (" + id3 + ")");
                    }
                }
            }
        } else {
            for (Region rg : getRegions()) {
                if (!rg.getMembers().contains(p.getName())) {
                    int sizeRegion = range(rg.getLevel());
                    Cuboid cub = new Cuboid(Bukkit.getWorld("world"), rg.getX() + sizeRegion, rg.getY() + sizeRegion, rg.getZ() + sizeRegion, rg.getX() - sizeRegion, rg.getY() - sizeRegion, rg.getZ() - sizeRegion).contract();
                    if ((!rg.getOwner().equals(p.getName())) && (cub.contains(e.getBlock()))) {
                        if (!rg.getMembers().contains(p.getName())) {
                            e.setCancelled(true);
                            p.sendMessage(Messages.prefix + "§cВы не можете ставить здесь блоки. " + rg.getOwner() + "(" + rg.getId() + ")");
                            break;
                        }
                    }
                }
            }
        }
    }

    public Integer range(Integer level) {
        Integer range;
        switch (level) {
            case 1:
                range = 3;
                break;
            case 2:
                range = 7;
                break;
            case 3:
                range = 10;
                break;
            case 4:
                range = 14;
                break;
            case 5:
                range = 17;
                break;
            case 6:
                range = 20;
                break;
            case 7:
                range = 24;
                break;
            default:
                range = 3;
                break;
        }
        return range;
    }

    @EventHandler
    public void onPlayerInteractEvent2(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (getRegions() != null) {
                for (Region rg : getRegions()) {
                    if (e.getClickedBlock().getX() == (rg.getX())) {
                        if (e.getClickedBlock().getY() == (rg.getY())) {
                            if (e.getClickedBlock().getZ() == (rg.getZ())) {
                                if (rg.getOwner().equals(p.getName())) {
                                    RegionInv.getRegionInventory().openMainMenu(p, rg);
                                } else {
                                    p.sendMessage(Messages.prefix + "Вы должны быть владельцем региона.");
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        for (Region rg : getRegions()) {
            if (getRegions() != null) {
                int sizeRegion = range(rg.getLevel());
                Cuboid cub = new Cuboid(Bukkit.getWorld("world"), rg.getX() + sizeRegion, rg.getY() + sizeRegion, rg.getZ() + sizeRegion, rg.getX() - sizeRegion, rg.getY() - sizeRegion, rg.getZ() - sizeRegion).contract();
                if (cub.contains(e.getClickedBlock().getLocation())) {
                    if (p.getName().equals(rg.getOwner()) || rg.getMembers().contains(p.getName())) {
                        break;
                    } else {
                        e.setCancelled(true);
                    }
                }
            }
        }
    }


    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        for (Region rg : getRegions()) {
            if (rg != null) {
                for (Block block : e.blockList()) {
                    if (block != null) {
                        if (block.getType() == Material.DIAMOND_BLOCK) {
                            if (rg.getX() == block.getX()) {
                                if (rg.getY() == block.getY()) {
                                    if (rg.getZ() == block.getZ()) {
                                        e.blockList().remove(block);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onPistonExtend(BlockPistonExtendEvent e) {
        for (Block block : e.getBlocks()) {
            if (block.getType() == Material.DIAMOND_BLOCK) {
                e.getBlocks().remove(block);
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPistonEvent(BlockPistonRetractEvent e) {
        for (Block block : e.getBlocks()) {
            if (block.getType() == Material.DIAMOND_BLOCK) {
                e.getBlocks().remove(block);
                e.setCancelled(true);
            }
        }
    }
}
