package EvgeniFomin.anarchy.manager;

import EvgeniFomin.anarchy.utils.Cuboid;
import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;

public class Region {
    private String owner;
    private int level;
    private int id;
    private int x;
    private int y;
    private int z;
    private ArrayList<String> members;

    public Region(String player) {
        this.owner = player;
    }

    public Region(Region region) {
        this.owner = region.getOwner();
        this.id = region.getId();
        this.x = region.getX();
        this.y = region.getY();
        this.z = region.getZ();
        this.level = region.getLevel();
        this.members = region.getMembers();
    }

    public Region(String player, int id, int x, int y, int z, int level, ArrayList<String> members) {
        this.owner = player;
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.level = level;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getZ() {
        return z;
    }

    public String getOwner() {
        return this.owner;
    }

    public Cuboid getCub() {
        return new Cuboid(Bukkit.getWorld("world"), getX() + range(getLevel()), getY() + range(getLevel()), getZ() + range(getLevel()), getX() - range(getLevel()), getY() - range(getLevel()), getZ() - range(getLevel())).contract();
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
}

