package me.devup.infected.framework.utils;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerUtils {

    public static void heal(Player p) {
        p.setHealth(p.getMaxHealth());

        p.setFoodLevel(20);

        p.setFireTicks(0);
    }

    public static void heal(Player p, boolean effects) {
        heal(p);

        if(effects) {
            for(PotionEffect pe : p.getActivePotionEffects()) {
                p.removePotionEffect(pe.getType());
            }
        }
    }

    public static void sendMessage(Player p, String message) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    public static void updateInventory(final Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                p.updateInventory();
            }
        }.runTaskLater(null, 2);
    }

    public static void clearInventory(Player p) {
        p.getInventory().clear();

        p.getInventory().setArmorContents(null);

        updateInventory(p);
    }

    public static void teleportPlayer(Player p, Location loc) {
        p.teleport(loc, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    public static void teleportPlayer(Player one, Player two) {
        teleportPlayer(one, two.getLocation());
    }

    public static void teleportPlayer(Player p, Entity e) {
        teleportPlayer(p, e.getLocation());
    }

}
