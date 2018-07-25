package me.devup.infected.plugin;

import me.devup.infected.framework.MinigameFramework;
import me.devup.infected.framework.arena.ArenaMapManager;
import me.devup.infected.framework.utils.DBConnector;
import me.devup.infected.plugin.game.listeners.block.BlockBreak;
import me.devup.infected.plugin.game.listeners.block.BlockChange;
import me.devup.infected.plugin.game.listeners.block.BlockPhysics;
import me.devup.infected.plugin.game.listeners.block.BlockPlace;
import me.devup.infected.plugin.game.listeners.player.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Infected extends JavaPlugin {

    private static Infected plugin;

    private static MinigameFramework framework;

    private static DBConnector connector;

    @Override
    public void onEnable() {
        plugin = this;

        framework = new MinigameFramework(this);

        connector = new DBConnector();

        ArenaMapManager.setInstance(new ArenaMapManager(this));

        new BlockBreak(this);

        new BlockChange(this);

        new BlockPhysics(this);

        new BlockPlace(this);

        new PlayerDamage(this);

        new PlayerDamageByPlayer(this);

        new PlayerDeath(this);

        new PlayerFood(this);

        new PlayerJoin(this);

        new PlayerQuit(this);

        new PlayerRespawn(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Infected getPlugin() {
        return plugin;
    }

    public static MinigameFramework getFramework() {
        return framework;
    }

    public static DBConnector getConnector() {
        return connector;
    }

    public void registerPlugin(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }

}
