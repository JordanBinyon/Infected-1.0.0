package me.devup.infected.framework.updater;

import org.bukkit.plugin.Plugin;

public class Updater implements Runnable {

    private Plugin pl;

    public Updater(Plugin pl) {
        this.pl = pl;

        pl.getServer().getScheduler().scheduleSyncRepeatingTask(pl, this, 0, 1);
    }

    public void run() {
        for(UpdateType type : UpdateType.values()) {
            if(type.elapsed()) {
                this.pl.getServer().getPluginManager().callEvent(new UpdateEvent(type));
            }
        }
    }

}
