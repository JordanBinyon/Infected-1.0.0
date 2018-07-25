package me.devup.infected.plugin.game.listeners.block;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

public class BlockBreak extends Listener {

    public BlockBreak(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if((!(e.getPlayer().isOp())) && (!(e.getPlayer().hasPermission("infected.block.break"))))
            e.setCancelled(true);
    }
}
