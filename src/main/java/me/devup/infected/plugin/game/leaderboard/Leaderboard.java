package me.devup.infected.plugin.game.leaderboard;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

@Getter
public abstract class Leaderboard {

    private LeaderboardType type;

    private Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.RED + "Leaderboard > " + type.toString().toLowerCase());

    public Leaderboard(LeaderboardType type) {
        this.type = type;
    }

    public abstract void update();

    public abstract void obtainLatestStats();

}
