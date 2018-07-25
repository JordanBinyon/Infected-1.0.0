package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDamage extends Listener {

    public PlayerDamage(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player))
            return;

        Player player = (Player) e.getEntity();

        Game game = GameManager.getInstance().getGame(player);

        if(game == null)
            return;

        switch (game.getArena().getState()) {
            case LOBBY: {
                if(e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                    player.teleport(Infected.getFramework().getLobby());
                }
                e.setCancelled(true);

                break;
            }
            case PREGAME: {
                e.setCancelled(true);

                break;
            }
            case INGAME: {
                break;
            }
        }
    }
}
