package me.devup.infected.framework;

import lombok.Getter;
import lombok.Setter;
import me.devup.infected.framework.arena.Arena;
import me.devup.infected.framework.updater.Updater;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class MinigameFramework {

    private Plugin plugin;

    private Location lobby;

    private int serverMultiplier = 0;

    private List<Arena> arenas = new ArrayList<Arena>();

    protected Updater updater;

    public MinigameFramework(Plugin plugin) {
        this.plugin = plugin;

        this.updater = new Updater(plugin);
    }

}
