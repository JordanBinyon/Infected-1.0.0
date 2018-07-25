package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.framework.utils.Message;
import me.devup.infected.framework.utils.PlayerUtils;
import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.account.AccountManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class PlayerJoin extends Listener {

    public PlayerJoin(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if(GameManager.getInstance().shouldCreateNewGame()) {
            GameManager.getInstance().createGame();
        }

        if(GameManager.getInstance().nextFreeGame() == null) {
            player.kickPlayer(Message.ERROR.format("&eOoopsy, looks like something went wrong buddy! Try again! :D"));

            return;
        }

        AccountManager.getInstance().generateAccount(player);

        Game game = GameManager.getInstance().nextFreeGame();

        switch (game.getArena().getState()) {
            case LOBBY: {
                PlayerUtils.teleportPlayer(player, Infected.getFramework().getLobby());

                PlayerUtils.heal(player, true);

                PlayerUtils.clearInventory(player);

                // TODO Give the player default lobby items

                break;
            }
            case PREGAME: {
                player.teleport(game.getArena().getMap().getSpawns().get(0).getLocation());

                AccountManager.getInstance().getAccount(player).equip();

                break;
            }
            case INGAME: {
                game.getPlayers().add(player.getUniqueId());

                game.infect(player);

                break;
            }
        }
    }
}
