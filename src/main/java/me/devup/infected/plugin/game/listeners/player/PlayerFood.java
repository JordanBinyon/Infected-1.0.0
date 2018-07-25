package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.plugin.Plugin;

public class PlayerFood extends Listener {

    public PlayerFood(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }
    
    @EventHandler
    public void onPlayerFood(FoodLevelChangeEvent e) {
        if(!(e.getEntity() instanceof Player))
            return;

        e.setCancelled(true);
    }
}
