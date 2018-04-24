package EvgeniFomin.anarchy.manager;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.Messages;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static EvgeniFomin.anarchy.manager.RegionManager.cache;
import static EvgeniFomin.anarchy.utils.ItemStackUtil.createItemStack;

public class RegionInv implements Listener {
    private static RegionInv regionInv;

    public static RegionInv getRegionInventory() {
        if (regionInv == null) {
            regionInv = new RegionInv();
        }
        return regionInv;
    }

    public static void openMember(Player p, String member) {
        Inventory inv = Bukkit.createInventory(null, 27, member);
        inv.setItem(12, createItemStack(Material.BARRIER, 1, (byte) 0, "Кикнуь"));
        inv.setItem(14, createItemStack(Material.ARROW, 1, (byte) 0, "Назад"));
        p.openInventory(inv);
    }

    public static void openUpdateRegion(Player p, Region rg) {
        Inventory inv = Bukkit.createInventory(null, 27, "Улучшение региона");
        if (rg.getLevel() == 1) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(260), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(81), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        } else if (rg.getLevel() == 2) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(264), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(388), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        } else if (rg.getLevel() == 3) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(46), 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(91), 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        } else if (rg.getLevel() == 4) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(129), 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(354), 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        } else if (rg.getLevel() == 5) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(378), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(49), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        } else if (rg.getLevel() == 6) {
            inv.setItem(0, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b1§7."));

            inv.setItem(3, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(4, createItemStack(Material.getMaterial(341), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(12, createItemStack(Material.getMaterial(368), 1, (byte) 0, "§6Требуемые предметы"));
            inv.setItem(13, createItemStack(Material.getMaterial(334), 10, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(22, createItemStack(Material.GLOWSTONE_DUST, 1, (byte) 0, "§6Требуемые предметы"));

            inv.setItem(8, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(9, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b2§7."));

            inv.setItem(17, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));

            inv.setItem(18, createItemStack(Material.SIGN, 1, (byte) 0, "§7Вариант улучшения §b3§7."));

            inv.setItem(26, createItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 5, "§aУлучшить?"));
            p.openInventory(inv);
        }
    }

    @EventHandler
    public void updateRegionInv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Region rg = Anarchy.getInstance().rgs.get(p);
        if (e.getClickedInventory().getName().equals("Улучшение региона")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§aУлучшить?")) {
                if (rg.getLevel() == 1) {
                    if (e.getSlot() == 8) {
                        update2v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update2v2(p, rg);
                    }
                } else  if (rg.getLevel() == 2) {
                    if (e.getSlot() == 8) {
                        update3v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update3v2(p, rg);
                    }
                }  else  if (rg.getLevel() == 3) {
                    if (e.getSlot() == 8) {
                        update4v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update4v2(p, rg);
                    }
                } else if (rg.getLevel() == 4) {
                    if (e.getSlot() == 8) {
                        update5v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update5v2(p, rg);
                    }
                } else if (rg.getLevel() == 5) {
                    if (e.getSlot() == 8) {
                        update6v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update6v2(p, rg);
                    }
                } else if (rg.getLevel() == 6) {
                    if (e.getSlot() == 8) {
                        update7v1(p, rg);
                    } else if (e.getSlot() == 17) {
                        update7v2(p, rg);
                    }
                }
            }
            e.setCancelled(true);
        }
    }

    public void update2v1(Player p, Region rg) {
        int melon = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.APPLE) {
                    melon += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (melon >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(360), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно яблок. =(");
        }
    }

    public void update2v2(Player p, Region rg) {
        int cactus = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.CACTUS) {
                    cactus += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (cactus >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(81), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно кактуса. =(");
        }
    }

    public void update3v1(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.DIAMOND) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(264), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно алмазиков. =(");
        }
    }

    public void update3v2(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.EMERALD) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(388), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно эмеральда. =(");
        }
    }

    public void update4v1(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.TNT) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 1) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(46), 1)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно динамита. =(");
        }
    }

    public void update4v2(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.getMaterial(91)) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 1) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(91), 1)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно свет. тыквы. =(");
        }
    }

    public void update5v1(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.EMERALD_ORE) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 1) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(129), 1)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно эмеральдовой руды. =(");
        }
    }

    public void update5v2(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.CAKE) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 1) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(354), 1)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно тортика. =(");
        }
    }

    public void update6v1(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.MAGMA_CREAM) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(378), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно магма крема. =(");
        }
    }

    public void update6v2(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.OBSIDIAN) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(49), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно обсидиана. =(");
        }
    }

    public void update7v1(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.SLIME_BALL) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(341), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно слизи. =(");
        }
    }

    public void update7v2(Player p, Region rg) {
        int diamond = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.LEATHER) {
                    diamond += item.getAmount();
                }
            }
        }
        int pearl = 0;
        for (ItemStack item : p.getInventory().getContents()) {
            if (item != null) {
                if (item.getType() == Material.ENDER_PEARL) {
                    pearl += item.getAmount();
                }
            }
        }
        if (diamond >= 10) {
            if (pearl >= 1) {
                p.sendMessage(Messages.prefix + "Ты повысил уровень своего регина!");
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(334), 10)});
                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.getMaterial(368), 1)});
                p.closeInventory();
                cache.asMap().get(p.getName()).remove(rg);
                rg.setLevel(rg.getLevel() + 1);
                cache.asMap().get(p.getName()).add(new Region(rg));
                ConfigManager.data().c().set("regions." + rg.getOwner() + "." + rg.getId() + ".level",rg.getLevel());
                ConfigManager.data().save();

                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
            } else {
                p.sendMessage(Messages.prefix + "У вас не достаточно жемчуга. =(");
            }
        } else {
            p.sendMessage(Messages.prefix + "У вас не достаточно кожы. =(");
        }
    }

    private Integer members(Region rg) {
        int i = 1;
        if (rg.getMembers().size() != 0) {
            i = rg.getMembers().size();
        }
        return i;
    }

    public int openMembers(Player p, int page_n, Region rg) {
        Inventory inv = Bukkit.createInventory(null, 45, "Управление участниками");
        ArrayList<String> members = new ArrayList<>(rg.getMembers());
        ArrayList<List<String>> pages = new ArrayList();
        if (members.size() > 21) {
            for (int i = 1; (i < members.size() / 2 + 2) && (!members.isEmpty()); i++) {
                List<String> l = new ArrayList();
                for (int i2 = 0; (i2 < 21) && (!members.isEmpty()); i2++) {
                    l.add(members.get(0));
                    members.remove(0);
                }
                pages.add(l);
            }
            List<String> page = pages.get(page_n);
            int[] slots;
            int length = (slots = Anarchy.getInstance().slots).length;
            for (int j = 0; j < length; j++) {
                int slot = slots[j];
                if (page.isEmpty()) {
                    break;
                }
                String player = page.get(0);
                ItemStack item = createItemStack(Material.SKULL_ITEM, 1, (byte) 3, player);
                SkullMeta skull = (SkullMeta) item.getItemMeta();
                skull.setOwner(player);
                skull.setDisplayName(player);
                item.setItemMeta(skull);
                inv.setItem(slot, item);
                page.remove(0);
            }
            if (page_n != 0) {
                inv.setItem(39, createItemStack(Material.ARROW, 1, (byte) 0, "Пред. страница"));
            }
            if (page_n + 1 != pages.size()) {
                inv.setItem(41, createItemStack(Material.ARROW, 1, (byte) 0, "След. страница"));
            }
            inv.setMaxStackSize(1337);
            p.openInventory(inv);
            return page_n;
        }
        if (members.isEmpty()) {
            inv.setItem(22, createItemStack(Material.BARRIER, 1, (byte) 0, "§bНет участников =("));
        } else {
            int[] slots2;
            int length2 = (slots2 = Anarchy.getInstance().slots).length;
            for (int k = 0; k < length2; k++) {
                int slot2 = slots2[k];
                if (members.isEmpty()) {
                    break;
                }
                String player2 = members.get(0);
                ItemStack item2 = createItemStack(Material.SKULL_ITEM, 1, (byte) 3, player2);
                SkullMeta skull2 = (SkullMeta) item2.getItemMeta();
                skull2.setOwner(player2);
                skull2.setDisplayName(player2);
                item2.setItemMeta(skull2);
                inv.setItem(slot2, item2);
                members.remove(0);
            }
        }
        inv.setMaxStackSize(1337);
        p.openInventory(inv);
        return page_n;
    }

    public void openMainMenu(Player p, Region region) {
        Anarchy.getInstance().rgs.put(p, region);
        Inventory inv = Bukkit.createInventory(null, 36, "Управление регионом");
        inv.setItem(11, createItemStack(Material.SKULL_ITEM, members(region), (byte) 3, "§3Участники [§7" + Anarchy.getInstance().rgs.get(p).getMembers().size() + "§3]"));
        inv.setItem(13, createItemStack(Material.REDSTONE, region.getLevel(), (byte) 0, "§6Улучшение региона"));
        inv.setItem(15, createItemStack(Material.BARRIER, 1, (byte) 0, "§cВыход"));
        inv.setItem(35, createItemStack(Material.GOLD_INGOT, 1, (byte) 0, "§6Донат"));
        inv.setItem(31, createItemStack(Material.EMPTY_MAP, 1, (byte) 0,
                "§bКраткая статистика",
                "§f",
                "§7Глава региона: §b" + region.getOwner(),
                "§7Уровень региона: §b" + region.getLevel(),
                "§7Количество участников: §b" + region.getMembers().size()));
        p.openInventory(inv);
    }

    @EventHandler
    public void invClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        if (e.getRawSlot() == 64537) {
            return;
        }
        if ((e.getCurrentItem() == null) || (e.getCurrentItem().getType() == Material.AIR)) {
            return;
        }
        String dname = e.getCurrentItem().getItemMeta().getDisplayName();
        if (inv.getName().equalsIgnoreCase("Управление участниками")) {
            if (dname.equalsIgnoreCase("§bНет участников =(")) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.ARROW) {
                if (dname.equalsIgnoreCase("След. страница")) {
                    int lastp = openMembers(p, (Anarchy.getInstance().pages.get(p)).intValue() + 1, Anarchy.getInstance().rgs.get(p));
                    Anarchy.getInstance().pages.put(p, Integer.valueOf(lastp));
                    e.setCancelled(true);
                }
                if (dname.equalsIgnoreCase("Пред. страница")) {
                    int lastp = openMembers(p, (Anarchy.getInstance().pages.get(p)).intValue() - 1, Anarchy.getInstance().rgs.get(p));
                    Anarchy.getInstance().pages.put(p, Integer.valueOf(lastp));
                    e.setCancelled(true);
                }
                return;
            }
            openMember(p, dname);
            e.setCancelled(true);
        }
        if (dname.equalsIgnoreCase("Кикнуь")) {
            Set<String> id = ConfigManager.data().c().getConfigurationSection("regions." + p.getName()).getKeys(false);
            for (String idd : id) {
                for (Region rg : Anarchy.getRegions()) {
                    if (rg.getId() == new Integer(idd)) {
                        if (rg.getOwner().equals(p.getName())) {
                            for (Region region : cache.asMap().get(p.getName())) {
                                if (region.getId() == new Integer(idd)) {
                                    region.getMembers().remove(inv.getName());
                                    Anarchy.getInstance().rgs.get(p).getMembers().remove(inv.getName());
                                    ArrayList<String> list = (ArrayList<String>) ConfigManager.data().c().get("regions." + p.getName() + "." + region.getId() + ".members");
                                    if (list.contains(inv.getName())) {
                                        list.remove(inv.getName());
                                        ConfigManager.data().c().set("regions." + p.getName() + "." + region.getId() + ".members", list);
                                        ConfigManager.data().save();
                                        p.sendMessage(Messages.prefix + "§b" + inv.getName() + " §7был кикнут.");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            openMembers(p, 0, Anarchy.getInstance().rgs.get(p));
        }
        if (dname.equalsIgnoreCase("Назад")) {
            openMembers(p, 0, Anarchy.getInstance().rgs.get(p));
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void handllerinv(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;
        if (e.getCurrentItem().getData() == null) return;

        if (e.getInventory().getName().equals("Управление регионом")) {
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3Участники [§7" + Anarchy.getInstance().rgs.get(p).getMembers().size() + "§3]")) {
                Anarchy.getInstance().pages.put(p, Integer.valueOf(0));
                openMembers(p, 0, Anarchy.getInstance().rgs.get(p));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Улучшение региона")) {
                openUpdateRegion(p, Anarchy.getInstance().rgs.get(p));
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cВыход")) {
                p.closeInventory();
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6Донат")) {
                p.closeInventory();
                p.sendMessage(Messages.prefix + "§cК сожалению пока не доступно. =(");
            }
            e.setCancelled(true);
        }

    }
}
