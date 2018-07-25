package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

public class PlayerDamageByPlayer extends Listener {

    public PlayerDamageByPlayer(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent e) {
        if(!(e.getEntity() instanceof Player))
            return;

        if((!(e.getDamager() instanceof Player)) && (!(e.getDamager() instanceof Arrow)))
            return;

        Player player = (Player) e.getEntity(), damager;

        if(e.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getDamager();

            damager = (Player) arrow.getShooter();
        } else {
            damager = (Player) e.getDamager();
        }

        Game playerGame = GameManager.getInstance().getGame(player), damagerGame = GameManager.getInstance().getGame(damager);

        if(playerGame == null || damagerGame == null || playerGame != damagerGame) {
            e.setCancelled(true);

            return;
        }

        switch (playerGame.getArena().getState()) {
            case LOBBY: {
                e.setCancelled(true);

                break;
            }
            case PREGAME: {
                e.setCancelled(true);

                break;
            }
            case INGAME: {
                if(playerGame.isInfected(player)) {
                    if(playerGame.isInfected(damager)) {
                        e.setCancelled(true);
                    }
                } else if(playerGame.isHuman(player)) {
                    if(playerGame.isHuman(damager)) {
                        e.setCancelled(true);
                    }
                }
                break;
            }
        }
    }

}
