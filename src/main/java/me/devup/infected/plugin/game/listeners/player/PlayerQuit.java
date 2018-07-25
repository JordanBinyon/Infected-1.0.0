package me.devup.infected.plugin.game.listeners.player;

import me.devup.infected.framework.utils.PlayerUtils;
import me.devup.infected.plugin.Infected;
import me.devup.infected.plugin.game.Game;
import me.devup.infected.plugin.game.GameManager;
import me.devup.infected.plugin.game.account.AccountManager;
import me.devup.infected.plugin.game.listeners.Listener;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;

public class PlayerQuit extends Listener {

    public PlayerQuit(Plugin plugin) {
        super(plugin);

        Infected.getPlugin().registerPlugin(this);
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        if (GameManager.getInstance().getGame(player) == null)
            return;

        Game game = GameManager.getInstance().getGame(player);

        game.removePlayer(player);

        PlayerUtils.clearInventory(player);

        PlayerUtils.heal(player);

        PlayerUtils.teleportPlayer(player, Infected.getFramework().getLobby());

        AccountManager.getInstance().saveAccount(player);
    }

}
