package me.devup.infected.plugin.game.listeners.block;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;

public class BlockPlace extends Listener {

    public BlockPlace(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if((!(e.getPlayer().isOp())) && (!(e.getPlayer().hasPermission("infected.block.break"))))
            e.setCancelled(true);
    }
}
