package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.account.AccountManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class PlayerRespawn extends Listener {

    public PlayerRespawn(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        Game game = GameManager.getInstance().getGame(player);

        if(game == null)
            return;

        switch (game.getArena().getState()) {
            case LOBBY: {
                e.setRespawnLocation(Infected.getFramework().getLobby());

                // TODO Give default items

                break;
            }
            case PREGAME: {
                e.setRespawnLocation(game.getArena().getMap().getSpawns().get(0).getLocation());

                AccountManager.getInstance().getAccount(player).equip();

                break;
            }
            case INGAME: {
                game.infect(player);

                e.setRespawnLocation(game.getRandomSpawn());

                break;
            }
        }
    }
}
