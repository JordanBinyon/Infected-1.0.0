package me.devup.infected.plugin.game.listeners.block;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.plugin.Plugin;

public class BlockPhysics extends Listener {

    public BlockPhysics(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler(priority= EventPriority.HIGHEST, ignoreCancelled=true)
    public void onBlockPhysics(BlockPhysicsEvent e) {
        if (e.getBlock().getType().equals(Material.STATIONARY_WATER))
            e.setCancelled(true);
    }
}
