package me.devup.infected.plugin.game.listeners.block;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.Plugin;

public class BlockChange extends Listener {

    public BlockChange(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onBlockChange(BlockFromToEvent e) {
        if(e.getToBlock().getType().equals(Material.WATER))
            e.setCancelled(true);
    }
}
