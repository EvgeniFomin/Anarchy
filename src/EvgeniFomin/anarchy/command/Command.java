package EvgeniFomin.anarchy.command;

import EvgeniFomin.anarchy.Anarchy;
import EvgeniFomin.anarchy.Messages;
import EvgeniFomin.anarchy.configManager.ConfigManager;
import EvgeniFomin.anarchy.manager.Region;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

import static EvgeniFomin.anarchy.Anarchy.getRegions;

public class Command implements CommandExecutor {
    private Anarchy plugin;

    public Command(Anarchy plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String string, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("rg")) {
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("addmember")) {
                        if (getRegions() != null) {
                            Location e = p.getTargetBlock(null, 10).getLocation();
                            for (Region rg : getRegions()) {
                                if (e.getX() == (rg.getX())) {
                                    if (e.getY() == (rg.getY())) {
                                        if (e.getZ() == (rg.getZ())) {
                                            if (rg.getOwner().equals(p.getName())) {
                                                if (!rg.getMembers().contains(args[1])) {
                                                    p.sendMessage(Messages.prefix + "§aВы успешно добавили игрока в регион.");
                                                    rg.getMembers().add(args[1]);
                                                    ArrayList<String> list = (ArrayList<String>) ConfigManager.data().c().get("regions." + p.getName() + "." + rg.getId() + ".members");
                                                    list.add(args[1]);
                                                    ConfigManager.data().c().set("regions." + p.getName() + "." + rg.getId() + ".members", list);
                                                    ConfigManager.data().save();
                                                    break;
                                                } else {
                                                    p.sendMessage(Messages.prefix + "§cЭтот игрок уже находится в регионе.");
                                                    break;
                                                }
                                            } else {
                                                p.sendMessage(Messages.prefix + "§cВы не являетесь создателем региона.");
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }
        return false;
    }
}
