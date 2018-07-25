package me.devup.infected.plugin.game.listeners;

import lombok.Getter;
import org.bukkit.plugin.Plugin;

@Getter
public class Listener implements org.bukkit.event.Listener {

    protected Plugin plugin;

    public Listener(Plugin plugin) {
        this.plugin = plugin;
    }

}
